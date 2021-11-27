from parser import Node, open_xml, strip_attrs

file_in = "schedule.xml"
file_out = "schedule.csv"

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
        this_node.add_child(node)
        parents.append(this_node)
        this_node = node
        in_body = True
        body = ""
    elif in_body and f[i] != "<" and f[i] != ">":
        body += f[i]
    elif f[i] == "<" and f[i + 1] == "/":
        in_body = False
        this_node.set_body(body)
        this_node = parents[len(parents) - 1]
        parents.pop()
        body = ""
    i += 1

with open(file_out, "w") as file:
    rows = root.get_children()[0].get_children()[1:]
    temp_line = ""
    for i in rows[0].get_children():
        if i.get_children():
            for j in i.get_children():
                temp_line += j.get_name() + ","
    temp_line = temp_line.rstrip(",") + "\n"
    file.write(temp_line)
    for i in rows:
        temp_line = ""
        for j in i.get_children():
            if j.get_children():
                for k in j.get_children():
                    temp_line += k.get_body().replace(",", "") + ","
        temp_line = temp_line.rstrip(",") + "\n"
        file.write(temp_line)
