import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline

INF = float("inf")


def dijkstra():
    heap = []
    results[1][0] = 0
    heapq.heappush(heap, (0, 1))

    while heap:
        curr_dist, curr = heapq.heappop(heap)

        for next_dest, next_dist in graph[curr]:
            dist = curr_dist + next_dist
            if dist < results[next_dest][k - 1]:
                results[next_dest][k - 1] = dist
                results[next_dest].sort()
                heapq.heappush(heap, (dist, next_dest))


n, m, k = map(int, input().split())

graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

results = [[INF] * k for _ in range(n + 1)]

dijkstra()

for i in range(1, n + 1):
    print(results[i][k - 1] if results[i][k - 1] != INF else -1)