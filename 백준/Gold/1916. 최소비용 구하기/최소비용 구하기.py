import sys
from collections import defaultdict

input = sys.stdin.readline

INF = float("inf")


def getMinIndex():
    m = INF
    idx = -1

    for i in range(1, n + 1):
        if not visited[i] and dist[i] < m:
            m = dist[i]
            idx = i

    return idx


def dijkstra(start, dest):
    dist[start] = 0

    for _ in range(n):
        curr = getMinIndex()
        visited[curr] = True

        for nextNode, cost in graph[curr]:
            if not visited[nextNode] and dist[curr] + cost < dist[nextNode]:
                dist[nextNode] = dist[curr] + cost

    return dist[dest]


n = int(input())
m = int(input())
graph = defaultdict(list)
for _ in range(m):
    start, dest, cost = map(int, input().split())
    graph[start].append((dest, cost))

start, dest = map(int, input().split())

visited = [False] * (n + 1)
dist = [INF] * (n + 1)


print(dijkstra(start, dest))