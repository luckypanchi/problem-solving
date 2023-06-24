import sys

input = sys.stdin.readline

INF = float("inf")


def bellman_ford(start):
    dist[start] = 0

    for i in range(1, n + 1):
        for j in range(m):
            a, b, c = graph[j]
            if dist[a] != INF and dist[a] + c < dist[b]:
                dist[b] = dist[a] + c
                if i == n:
                    return True

    return False


n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(m)]

dist = [INF] * (n + 1)

check = bellman_ford(1)

if check:
    print(-1)
else:
    for i in range(2, n + 1):
        if dist[i] == INF:
            print(-1)
        else:
            print(dist[i])