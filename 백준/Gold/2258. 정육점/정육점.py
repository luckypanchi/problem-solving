import sys

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
meats = [list(map(int, input().split())) for _ in range(n)]
meats.sort(key=lambda x: (x[1], -x[0]))

answer = INF
weight = 0
cost = 0

for i in range(n):
    w, c = meats[i]

    weight += w

    if i >= 1 and meats[i - 1][1] != c:
        cost = 0

    cost += c

    if weight >= m:
        answer = min(answer, cost)

if answer == INF:
    answer = -1

print(answer)