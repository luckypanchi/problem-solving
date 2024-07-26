import sys

input = sys.stdin.readline

LIMIT = 1000000

f = [0] * (LIMIT + 1)
g = [0] * (LIMIT + 1)

for i in range(1, LIMIT + 1):
    j = 1
    while i * j < LIMIT + 1:
        f[i * j] += i
        j += 1

    g[i] = g[i - 1] + f[i]


tc = int(input())
for _ in range(tc):
    n = int(input())
    print(g[n])