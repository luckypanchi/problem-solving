import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline
INF = float("inf")


def dijkstra(minCost):
    distances = [INF] * (n + 1)
    distances[start] = 0

    h = [(distances[start], start)]

    while h:
        currCost, curr = heapq.heappop(h)

        if distances[curr] < currCost:
            continue

        for _next, nextCost in graph[curr]:

            if minCost < nextCost:
                continue

            cost = nextCost + currCost
            if cost < distances[_next] and cost <= limit:
                distances[_next] = cost
                heapq.heappush(h, (cost, _next))

    return distances[dest] <= limit


n, m, start, dest, limit = map(int, input().split())
totalCost = 0
graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))
    totalCost += c

left, right = 0, totalCost + 1
answer = -1
while left <= right:
    mid = (left + right) // 2
    if dijkstra(mid):
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)