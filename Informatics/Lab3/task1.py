isu = 338987

eyes = [":", ";", "X", "="]
nose = ["-", "<", "-{", "<{"]
mouth = ["(", ")", "O", "|", "\\", "/", "P"]

smile = eyes[isu % 5] + nose[isu % 4] + mouth[isu % 7]

import re

tests = [r'X<{/:<{(;-{O=<{):<P;-{\=-{)X<{O=<{)X-{O',
         r'=<\:-\=-)X-{/X<{\;-{/X<{/;<\:-{)X<{/',
         r'X<{/;<{OX<{/X<{/X-|=<(=-{(;<{OX-{\;-{P',
         r';-(X<{/:<{/;<{):-P=-{|X<{/X<{/X<{/X<{/',
         r'X-{\=-{)X-{\X<{/=-PX<P;-{(;-{\X<{)=<{|']

smile = re.compile(smile)

for i in tests:
    print(len(re.findall(smile, i)))
