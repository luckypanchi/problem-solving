import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())

graph = defaultdict(list)
in_degree = [0] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    in_degree[b] += 1

answer = []
heap = []
visited = [False] * (n + 1)

for i in range(1, n + 1):
    if in_degree[i] == 0:
        visited[i] = True
        heapq.heappush(heap, i)

while heap:
    curr = heapq.heappop(heap)

    answer.append(curr)

    for node in graph[curr]:
        if not visited[node]:
            in_degree[node] -= 1
            if in_degree[node] == 0:
                visited[node] = True
                heapq.heappush(heap, node)

print(*answer)