import sys

input = sys.stdin.readline


n = int(input())
string = input().strip()
r = 31
m = 1234567891

total = 0
for idx in range(n):
    s = string[idx]
    total += (ord(s) - ord("a") + 1) * r**idx

print(total % m)