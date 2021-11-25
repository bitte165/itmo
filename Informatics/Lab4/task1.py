import xmlplain

xml_name = "schedule.xml"
yaml_name = "schedule1.yaml"

with open(xml_name) as inf:
    root = xmlplain.xml_to_obj(inf, strip_space=True, fold_dict=True)

with open(yaml_name, "w") as outf:
    xmlplain.obj_to_yaml(root, outf)
