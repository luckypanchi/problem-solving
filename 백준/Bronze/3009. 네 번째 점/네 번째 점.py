import sys
from collections import defaultdict

input = sys.stdin.readline
INF = float("inf")


y = defaultdict(int)
x = defaultdict(int)

for _ in range(3):
    a, b = map(int, input().split())
    y[a] += 1
    x[b] += 1

for p in y:
    if y[p] == 1:
        print(p, end=" ")

for p in x:
    if x[p] == 1:
        print(p)