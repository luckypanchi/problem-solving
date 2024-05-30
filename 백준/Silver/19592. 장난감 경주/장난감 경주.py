import sys
from math import ceil, floor

input = sys.stdin.readline

INF = float("inf")


tc = int(input())
for _ in range(tc):
    n, x, y = map(int, input().split())
    v = list(map(int, input().split()))

    if max(v[:-1]) < v[n - 1]:
        print(0)
        continue

    minTime = x / max(v[:-1])
    answer = floor(x - v[n - 1] * (minTime - 1)) + 1
    if y < answer:
        print(-1)
    else:
        print(answer)
