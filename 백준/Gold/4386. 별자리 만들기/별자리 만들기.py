import sys
import heapq
from collections import defaultdict

input = sys.stdin.readline


def prim(start, graph):
    visited = [False] * n
    visited[start] = True
    heap = graph[start]
    heapq.heapify(heap)
    total = 0

    while heap:
        w, node = heapq.heappop(heap)
        if not visited[node]:
            visited[node] = True
            total += w
            for next_edge in graph[node]:
                _w, _node = next_edge
                if not visited[_node]:
                    heapq.heappush(heap, next_edge)

    return total


n = int(input())
points = [list(map(float, input().split())) for _ in range(n)]

graph = defaultdict(list)
for i in range(n):
    for j in range(n):
        y1, x1 = points[i]
        y2, x2 = points[j]
        d = ((y1 - y2) ** 2 + (x1 - x2) ** 2) ** 0.5
        graph[i].append((d, j))
        graph[j].append((d, i))


answer = prim(0, graph)
print(answer)