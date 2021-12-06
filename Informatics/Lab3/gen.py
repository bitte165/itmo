#!/usr/bin/python3
import random, re


eyes = [":", ";", "X", "="]
nose = ["-", "<", "-{", "<{"]
mouth = ["(", ")", "O", "|", "\\", "/", "P"]

isu = 338987
s = eyes[isu % 5] + nose[isu % 4] + mouth[isu % 7]
regexp = r"X<{/"

tests = []

for j in range(5):
	res = ""
	for i in range(10):
			n = random.randint(1,5)
			if n == 1:
				res += regexp
			else:
				res += random.choice(eyes) + random.choice(nose) + random.choice(mouth)
	tests.append(res)


print('\n'.join(tests))

regexp = re.compile(regexp)

for i in tests:
	print(len(re.findall(regexp, i)))
