#!/usr/bin/python3
import sys


class Node:
    def __init__(self, name):
        self.__name = name
        self.__body = ""
        self.__children = []

    def add_child(self, child):
        if type(child) == Node:
            self.__children.append(child)

    def add_body(self, body):
        self.__body = body

    def get_name(self):
        return self.__name

    def get_body(self):
        return self.__body

    def get_children(self):
        return self.__children


def open_xml(file):
    with open(file) as file:
        file = file.read()
        file = file.replace('\n', '').replace('   ', '')
    header = file[file.find('<', 0):file.find('>', 0) + 1]
    header = header.replace("'", '"')
    if header.startswith("<?xml ") and header.endswith("?>"):
        if header == '<?xml version="1.0" encoding="UTF-8"?>':
            file = file.replace(header, "", 1)
        else:
            sys.exit("ParsingError: Error parsing the header")
    return file


def write_to_file(node, file, n=-1):
    if node.get_name() == "root":
        for child in node.get_children():
            write_to_file(child, file, n + 1)
    else:
        if node.get_children():
            file.write(n * '  ' + node.get_name() + ":\n")
            for child in node.get_children():
                write_to_file(child, file, n + 1)
        elif node.get_body():
            file.write(n * '  ' + node.get_name() + ": " + node.get_body() + "\n")
        elif not node.get_children():
            file.write(n * '  ' + node.get_name() + ": ~" + "\n")


def main():
    global file_in, file_out
    usage = "usage: ./parser.py [-f XML file] [-o YAML output file name]"
    try:
        if sys.argv[1] == "-f":
            file_in = sys.argv[2]
        if sys.argv[3] == "-o":
            file_out = sys.argv[4]
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
            node = Node(name)
            this_node.add_child(node)
            parents.append(this_node)
            this_node = node
            name = ""
            in_body = True
            body = ""
        elif in_body and f[i] != "<" and f[i] != ">":
            body += f[i]
        elif f[i] == "<" and f[i + 1] == "/":
            in_body = False
            this_node.add_body(body)
            this_node = parents[len(parents) - 1]
            parents.pop()
            body = ""
        i += 1

    with open(file_out, "w") as out:
        write_to_file(root, out)


if __name__ == "__main__":
    main()
