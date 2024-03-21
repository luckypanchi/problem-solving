import sys

input = sys.stdin.readline


string = list(input().strip())
s = string[0]

for i in range(1, len(string)):
    if s[i - 1] < string[i]:
        s = string[i] + s
    else:
        s = s + string[i]

answer = s[::-1]

print(answer)