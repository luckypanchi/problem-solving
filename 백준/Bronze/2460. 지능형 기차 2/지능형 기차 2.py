import sys

input = sys.stdin.readline


curr = 0
m = -1
for _ in range(10):
    a, b = map(int, input().split())
    curr -= a
    curr = min(curr + b, 10000)
    m = max(m, curr)

print(m)