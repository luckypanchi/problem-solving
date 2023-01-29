import sys

input = sys.stdin.readline


n = int(input())
m = int(input())
s = input().strip()

target = "I"
for _ in range(n):
    target += "OI"

answer = 0

for i in range(m - len(target) + 1):
    if s[i : i + len(target)] == target:
        answer += 1

print(answer)