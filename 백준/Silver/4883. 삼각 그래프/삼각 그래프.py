import sys

input = sys.stdin.readline

k = 0
while True:
    n = int(input())
    if n == 0:
        break

    k += 1

    graph = [list(map(int, input().split())) for _ in range(n)]

    graph[1][0] += graph[0][1]
    graph[1][1] += min(graph[1][0], graph[0][1], graph[0][1] + graph[0][2])
    graph[1][2] += min(graph[1][1], graph[0][1], graph[0][1] + graph[0][2])

    for i in range(2, n):
        graph[i][0] += min(graph[i - 1][0], graph[i - 1][1])
        graph[i][1] += min(min(graph[i - 1]), graph[i][0])
        graph[i][2] += min(graph[i - 1][1], graph[i - 1][2], graph[i][1])

    print(f"{k}. {graph[n - 1][1]}")