import sys
import heapq
from collections import defaultdict

input = sys.stdin.readline

INF = float("inf")


def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))

    dist = [INF] * (n + 1)
    dist[start] = 0

    while heap:
        curr_cost, curr_node = heapq.heappop(heap)

        if dist[curr_node] < curr_cost:
            continue

        for next_cost, next_node in graph[curr_node]:
            d = next_cost + curr_cost
            if d < dist[next_node]:
                dist[next_node] = d
                heapq.heappush(heap, (d, next_node))

    return dist


n, e = map(int, input().split())
graph = defaultdict(list)
for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

v1, v2 = map(int, input().split())

from_start = dijkstra(1)
from_v1 = dijkstra(v1)
from_v2 = dijkstra(v2)

path1 = from_start[v1] + from_v1[v2] + from_v2[n]
path2 = from_start[v2] + from_v2[v1] + from_v1[n]

answer = min(path1, path2)

if answer == INF:
    answer = -1

print(answer)