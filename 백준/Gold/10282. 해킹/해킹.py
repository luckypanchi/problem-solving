import sys
import heapq
from collections import defaultdict

input = sys.stdin.readline

INF = float("inf")


tc = int(input())
for _ in range(tc):
    n, d, c = map(int, input().split())

    graph = defaultdict(list)
    for _ in range(d):
        a, b, s = map(int, input().split())
        graph[b].append((a, s))

    dists = [INF] * (n + 1)
    dists[c] = 0
    heap = []
    heapq.heappush(heap, (0, c))

    while heap:
        curr_cost, curr = heapq.heappop(heap)

        if dists[curr] < curr_cost:
            continue

        for next_node, next_cost in graph[curr]:
            d = curr_cost + next_cost
            if d < dists[next_node]:
                dists[next_node] = d
                heapq.heappush(heap, (d, next_node))

    infected = [dists[i] for i in range(1, n + 1) if dists[i] != INF]
    print(len(infected), max(infected))