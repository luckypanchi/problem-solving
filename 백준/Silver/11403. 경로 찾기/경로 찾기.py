import sys

input = sys.stdin.readline
INF = int(1e9)


n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

for a in range(n):
    for b in range(n):
        if graph[a][b] == 0:
            graph[a][b] = INF

for k in range(n):
    for a in range(n):
        for b in range(n):
            if graph[a][b] != 1 and graph[a][k] + graph[k][b] < graph[a][b]:
                graph[a][b] = 1

for a in range(n):
    for b in range(n):
        if graph[a][b] == INF:
            graph[a][b] = 0


for row in graph:
    print(*row)
