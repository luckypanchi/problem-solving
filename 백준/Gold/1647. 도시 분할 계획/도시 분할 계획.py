import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline


def prim(start, graph):
    visited = [False] * (n + 1)
    heap = graph[start]
    heapq.heapify(heap)
    total = []

    visited[start] = True
    while heap:
        w, node = heapq.heappop(heap)
        if not visited[node]:
            visited[node] = True
            total.append(w)
            for _w, _node in graph[node]:
                if not visited[_node]:
                    heapq.heappush(heap, (_w, _node))
    return total


n, m = map(int, input().split())
graph = defaultdict(list)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))


w = prim(1, graph)
answer = sum(w) - max(w)
print(answer)