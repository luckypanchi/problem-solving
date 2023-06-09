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

    for i in range(1, n + 1):
        if not visited[i]:
            return -1
    return answer


n, m = map(int, input().split())
gender = [-1] + list(input().split())

graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int, input().split())
    if gender[a] != gender[b]:
        graph[a].append((c, b))
        graph[b].append((c, a))


answer = prim(1, graph)


print(answer)