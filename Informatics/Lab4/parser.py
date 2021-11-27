#!/usr/bin/python3
import sys


class Node:
    def __init__(self, name):
        self.__name = name
        self.__body = ""
        self.__children = []
        self.__parent = None

    def add_child(self, child):
        if type(child) == Node:
            self.__children.append(child)
            child.__parent = self

    def set_body(self, body):
        self.__body = body

    def get_name(self):
        return self.__name

    def get_body(self):
        return self.__body

    def get_children(self):
        return self.__children

    def get_parent(self):
        return self.__parent


def open_xml(file):
    with open(file) as file:
        file = file.read()
    # validate header if present and remove it for parsing
    header = file[file.find('<', 0):file.find('>', 0) + 1]
    if header.startswith("<?xml ") and header.endswith("?>"):
        header = header.replace("'", "")
        variants = ['<?xml version="1.0" encoding="UTF-8"?>', '<?xml version="1.1" encoding="UTF-8"?>',
                    '<?xml version="1.0"?>', '<?xml version="1.1"?>']
        if header in variants:
            file = file.replace(header, '')
        else:
            sys.exit("ParseError: error parsing header")
    # check that the root element is present and enclosed
    first_tag = file[file.find('<', 0):file.find('>', 0) + 1].replace("<", "</")
    file = file.strip()
    if file.endswith(first_tag):
        return file
    else:
        sys.exit("ParseError: " + first_tag + " missing")


def strip_attrs(name):
    attrs = name.split()
    name = attrs.pop(0)
    for i in range(len(attrs)):
        attr_name, attr_value = attrs[i].split("=")
        # chooses quotes
        if attr_value[0] == attr_value[-1] == '"':
            attr_value = attr_value.strip('"')
        elif attr_value[0] == attr_value[-1] == "'":
            attr_value = attr_value.strip("'")
        else:
            exit("ParseError: error parsing attribute value")
        # int to str (xml attributes can't be ints)
        if attr_value.isnumeric():
            attr_value = "'" + attr_value + "'"
        attrs[i] = attr_name, attr_value
    return name, attrs


def write_line(file, n, name, body, indent):
    if indent == 'dict':
        file.write(n * '  ' + name + ":" + body + "\n")
    elif indent == 'list':
        file.write((n - 1) * '  ' + '- ' + name + ":" + body + "\n")


def write_to_file(node, file, n=-1, indent='dict'):
    # changes the indentation to list-like instead of the default to allow for duplicate keys
    if node.get_name() != "root" and node.get_parent().get_children():
        names = [x.get_name() for x in node.get_parent().get_children()]
        if len(set(names)) == len(names):
            indent = 'dict'
        else:
            indent = 'list'

    if node.get_name() == "root":
        for child in node.get_children():
            write_to_file(child, file, n + 1, indent)
    else:
        # case 1: node only has children -> print its children
        if node.get_children() and not node.get_body():
            write_line(file, n, node.get_name(), '', indent)
            for child in node.get_children():
                write_to_file(child, file, n + 1, indent)
        # case 2: node has a body -> print the body and children if present
        elif node.get_body():
            body = node.get_body()
            # tries to format newlines (it's hard)
            if body.startswith("\n") and body.endswith("\n"):
                body = body[1:-1]
            if "\n" in body:
                body = ">\n" + body
                body = body.replace("\n", "\n" + (n + 1) * '  ')
            if ": " in body or body.startswith(" ") or body.endswith(" "):
                if "'" not in body:
                    body = "'" + body + "'"
                elif '"' not in body:
                    body = '"' + body + '"'
                else:
                    sys.exit("ParseError: quote problems in '" + node.get_name() + "'")
            # prints only body
            if not node.get_children():
                write_line(file, n, node.get_name(), ' ' + body, indent)
            # prints children and body in a list
            else:
                write_line(file, n, node.get_name(), '', indent)
                for child in node.get_children():
                    write_line(file, (n + 1), child.get_name(), ' ' + child.get_body(), 'list')
                file.write(n * '  ' + '- ' + node.get_body() + "\n")
        # case 3: node has neither -> print a null character
        elif not node.get_children():
            write_line(file, n, node.get_name(), " ~", indent)


def main(args):
    file_in = file_out = ''
    usage = "usage: ./parser.py [-f XML file] [-o YAML output file name]"
    try:
        if args[1] == "-f":
            file_in = args[2]
        if args[3] == "-o":
            file_out = args[4]
    except IndexError:
        sys.exit(usage)

    i = 0
    f = open_xml(file_in)
    name = body = ""
    in_name = in_body = False
    root = Node("root")
    this_node = root
    parents = []
    while i < len(f):
        if f[i] == '<' and f[i + 1] != '/':
            name = ""
            in_name = True
        elif in_name and f[i] != "<" and f[i] != ">":
            name += f[i]
        elif in_name and f[i] == ">":
            in_name = False
            name, attrs = strip_attrs(name)
            node = Node(name)
            # adds xml attributes as separate keys
            if attrs:
                for attr_name, attr_value in attrs:
                    attr_name = "'@" + attr_name + "'"
                    attr_node = Node(attr_name)
                    attr_node.set_body(attr_value)
                    node.add_child(attr_node)
            this_node.add_child(node)
            parents.append(this_node)
            this_node = node
            body = ""
            in_body = True
        elif in_body and f[i] != "<" and f[i] != ">":
            body += f[i]
        elif f[i] == "<" and f[i + 1] == "/" and f:
            close_tag = f[(i + 2):f.find(">", i)]
            parent_children = [x.get_name() for x in parents[-1].get_children()]
            if close_tag in parent_children:
                in_body = False
                this_node.set_body(body)
                this_node = parents.pop()
                body = ""
            else:
                sys.exit("ParseError: tag error somewhere in '" + parents[-1].get_name() + "'")
        i += 1

    with open(file_out, "w") as out:
        write_to_file(root, out)


if __name__ == "__main__":
    main(sys.argv)
