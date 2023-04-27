import sys
import heapq
from collections import defaultdict

input = sys.stdin.readline


def prim(start, graph):
    visited = [False] * (n + 1)
    visited[start] = True
    heap = graph[start]
    heapq.heapify(heap)
    answer = 0

    while heap:
        w, node = heapq.heappop(heap)
        if not visited[node]:
            visited[node] = True
            answer += w
            for next_edge in graph[node]:
                _w, _node = next_edge
                if not visited[_node]:
                    heapq.heappush(heap, next_edge)

    return answer


n = int(input())
m = int(input())
graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

answer = prim(1, graph)

print(answer)