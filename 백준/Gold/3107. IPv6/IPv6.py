import sys

input = sys.stdin.readline


string = input().strip().split(":")
n = 0
flag = False
for s in string:
    if s != "":
        n += 1
    else:
        flag = True

answer = []

for s in string:
    if s != "":
        answer.append("0" * (4 - len(s)) + s)
    elif flag:
        for _ in range(8 - n):
            answer.append("0000")
        flag = False

print(":".join(answer))