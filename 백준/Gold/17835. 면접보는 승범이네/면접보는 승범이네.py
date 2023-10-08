import sys
from collections import defaultdict
from heapq import heappop, heappush

input = sys.stdin.readline

INF = float("inf")


def dijkstra():
    heap = []

    for start in starts:
        heap.append((0, start))
        results[start] = 0

    while heap:
        dist, curr = heappop(heap)

        if results[curr] < dist:
            continue

        for d, next_city in graph[curr]:
            total_dist = dist + d
            if total_dist < results[next_city]:
                results[next_city] = total_dist
                heappush(heap, (total_dist, next_city))


n, m, k = map(int, input().split())
graph = defaultdict(list)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[b].append((c, a))

starts = list(map(int, input().split()))
results = [INF] * (n + 1)

dijkstra()

answer_city = 0
answer_cost = 0

for city, cost in enumerate(results):
    if answer_cost < cost and cost != INF:
        answer_city = city
        answer_cost = cost

print(answer_city)
print(answer_cost)