import re
from parser import Node, open_xml, write_to_file


file_in = "schedule.xml"
file_out = "schedule2.yaml"
i = 0
name = body = ""
in_name = in_body = False
f = open_xml(file_in)
f = f.replace("   ", "").replace("\n", "")
root = Node("root")
this_node = root
parents = []
name_reg = r'<([A-Za-z\_]+[A-Za-z0-9\-\_\.]*)(?:\ ([A-Za-z\_]+[A-Za-z0-9\-\_\.]*(?=\=))\=(?:\"([^\"]+)\"|\'([^\']+)\'))*>'
body_reg = r"(?<=>)([^<>]*?)</([A-Za-z\_]+[A-Za-z0-9\-\_\.]*)>"
while i < len(f):
    if f[i] == '<' and f[i+1] != '/':
        in_name = True
        reg_res = re.search(name_reg, f[i:])
        name = reg_res.group(1)
        node = Node(name)
        if reg_res.group(2):
            attr_name = "'@" + reg_res.group(2) + "'"
            attr_value = reg_res.group(3) if reg_res.group(3) else reg_res.group(4)
            if attr_value.isnumeric():
                attr_value = "'" + attr_value + "'"
            attr_node = Node(attr_name)
            attr_node.set_body(attr_value)
            node.add_child(attr_node)
        i += len(name)
    elif in_name and f[i] == ">":
        in_name = False
        this_node.add_child(node)
        parents.append(this_node)
        this_node = node
        name_temp = name
        name = ""
        in_body = True
        body = ""
    elif in_body and f[i] != "<" and f[i] != ">":
        body_rxd = re.search(body_reg, f[i-1:])
        body = body_rxd.group(1)
        if body_rxd:
            j = f.find(body_rxd.group(1), i)
            i = j + len(body)
            i = f.find("</", i) - 1
    elif f[i] == "<" and f[i+1] == "/":
        in_body = False
        this_node.set_body(body)
        this_node = parents.pop()

        body = ""
    i += 1


with open(file_out, "w") as out:
    write_to_file(root, out)
