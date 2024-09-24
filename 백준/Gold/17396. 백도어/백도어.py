import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
is_seen = list(map(int, input().split()))
graph = defaultdict(list)
for _ in range(m):
    a, b, t = map(int, input().split())
    graph[a].append((b, t))
    graph[b].append((a, t))

dist = [INF] * n
h = []

dist[0] = 0
heapq.heappush(h, (dist[0], 0))

while h:
    prev_cost, curr = heapq.heappop(h)

    if dist[curr] < prev_cost:
        continue

    for next_node, cost in graph[curr]:
        if next_node != n - 1 and is_seen[next_node] == 1:
            continue

        next_cost = prev_cost + cost

        if next_cost < dist[next_node]:
            dist[next_node] = next_cost
            heapq.heappush(h, (next_cost, next_node))


print(dist[n - 1] if dist[n - 1] != INF else -1)