import sys
from itertools import combinations

input = sys.stdin.readline
INF = int(1e9)


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

houses = []
chickens = []

for i in range(n):
    for j in range(n):
        if board[i][j] == 1:
            houses.append((i, j))
        if board[i][j] == 2:
            chickens.append((i, j))

combs = list(combinations(chickens, m))
answer = INF

for comb in combs:
    total = 0
    for hy, hx in houses:
        m = INF
        for cy, cx in comb:
            m = min(m, abs(hy - cy) + abs(hx - cx))
        total += m
    answer = min(answer, total)

print(answer)