#!/usr/bin/python3
import sys
x = sys.argv[1]
print(sys.argv)
s = list(x)
s = list(map(int,s))

s1 = (s[0] + s[2] + s[4] + s[6]) % 2
s2 = (s[1] + s[2] + s[5] + s[6]) % 2
s3 = (s[3] + s[4] + s[5] + s[6]) % 2

err = str(s3) + str(s2) + str(s1)
i = int(err,2) - 1
s[i] = int(not s[i])

print(''.join(map(str,s)))
