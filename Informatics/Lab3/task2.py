import re

tests = ['Прямошея абстракция перемащается по неевклидову пространству',
'Регулярные выражения не очень и регулярные на самом деле',
'Задание на 100 баллов',
'Системное и прикладное программное что',
'Приказ об отчислении от 31.02.22']

regex = re.compile(r"([А-Яа-я]*[уеыаоэёяию]{2}[А-Яа-я]*)(?=\s[уеыаоэёяию]*[^уеыаоэёяию]?[уеыаоэёяию]*[^уеыаоэёяию]?[уеыаоэёяию]*[^уеыаоэёяию]?[уеыаоэёяию]*(?:\s|$))")
for i in tests:
    print(' '.join(re.findall(regex,i)))
