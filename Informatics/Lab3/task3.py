import re

tests = ["Аталян А.А. P3108",
         "Приходько М.А. P3112",
         "Короткова К.К. P3108",
         "Акимов А.А. P3111",
         "Петров П.П. P3108",
         "Третьяков И.А. P3108"]

regex = re.compile(r"([А-Я])[а-я]+ \1\.\1\. P3108")
for i in tests:
    res = re.findall(regex, i)
    if res:
        continue
    print(i)
