import sys

input = sys.stdin.readline


n = int(input())
a, b = 100, 100
for _ in range(n):
    c, d = map(int, input().split())
    if c < d:
        a -= d
    elif d < c:
        b -= c

print(a)
print(b)