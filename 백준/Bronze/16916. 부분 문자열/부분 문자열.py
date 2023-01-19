import sys

input = sys.stdin.readline


s = input().strip()
p = input().strip()

if p in s:
    print(1)
else:
    print(0)
