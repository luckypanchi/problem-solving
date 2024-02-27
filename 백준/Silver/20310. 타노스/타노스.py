import sys

input = sys.stdin.readline


s = list(input().strip())
n = len(s)

zeroCount = s.count("0") // 2
oneCount = s.count("1") // 2

flag = [False] * n

count = 0
for i in range(n):
    if s[i] == "1" and count < oneCount:
        flag[i] = True
        count += 1

count = 0
for i in range(n - 1, -1, -1):
    if s[i] == "0" and count < zeroCount:
        flag[i] = True
        count += 1

answer = ""
for i in range(n):
    if not flag[i]:
        answer += s[i]

print(answer)