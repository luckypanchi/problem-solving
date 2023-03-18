import sys
import heapq

input = sys.stdin.readline

INF = float("inf")

n, dest = map(int, input().split())
graph = [[] for _ in range(dest + 1)]
dist = [INF] * (dest + 1)

for i in range(dest):
    graph[i].append((i + 1, 1))

for _ in range(n):
    a, b, c = map(int, input().split())
    if b < dest + 1:
        graph[a].append((b, c))

que = []
dist[0] = 0
heapq.heappush(que, (0, 0))

while que:
    d, curr = heapq.heappop(que)

    if dist[curr] < d:
        continue

    for nxt, nd in graph[curr]:
        cost = d + nd
        if cost < dist[nxt]:
            dist[nxt] = cost
            heapq.heappush(que, (cost, nxt))

print(dist[dest])