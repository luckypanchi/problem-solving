import sys

input = sys.stdin.readline


number = input().strip()
length = len(number) // 2

s1 = sum([int(x) for x in number[:length]])
s2 = sum([int(x) for x in number[length:]])

if s1 == s2:
    print("LUCKY")
else:
    print("READY")
