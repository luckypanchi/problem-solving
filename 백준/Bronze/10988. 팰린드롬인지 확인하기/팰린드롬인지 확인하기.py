import sys

input = sys.stdin.readline


s = input().strip()

flag = True
for i in range(len(s)):
    left = i
    right = len(s) - 1 - i
    if s[left] != s[right]:
        flag = False
        break

print(1 if flag else 0)