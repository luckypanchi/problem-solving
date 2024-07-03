import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline

INF = float("inf")


def dijkstra():
    dist = [INF] * (v + 1)
    dist[start] = 0

    h = []
    heapq.heappush(h, (dist[start], start))

    while h:
        d, curr = heapq.heappop(h)

        if dist[curr] < d:
            continue

        for nextNode, cost in graph[curr]:
            total = d + cost
            if total < dist[nextNode]:
                dist[nextNode] = total
                heapq.heappush(h, (total, nextNode))

    return dist


v, e = map(int, input().split())
start = int(input())

graph = defaultdict(list)
for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

distances = dijkstra()

for d in distances[1:]:
    if d == INF:
        print("INF")
    else:
        print(d)