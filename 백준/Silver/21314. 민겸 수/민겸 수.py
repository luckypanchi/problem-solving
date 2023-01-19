import sys
import re

input = sys.stdin.readline


string = input().strip()

answers = []

p = re.compile("M*K?")
result = p.findall(string)
total = ""
for s in result:
    if "K" in s:
        total += "5" + "0" * (len(s) - 1)
    elif "M" in s:
        total += "1" * len(s)

answers.append(total)

p = re.compile("M+|K")
result = p.findall(string)
total = ""
for s in result:
    if "K" in s:
        total += "5"
    elif "M" in s:
        total += "1" + "0" * (len(s) - 1)

answers.append(total)

for a in answers:
    print(a)
