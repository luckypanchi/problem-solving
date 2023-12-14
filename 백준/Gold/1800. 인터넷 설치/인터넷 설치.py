import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline
INF = float("inf")


def dijkstra(start, base):
    freeCables = [INF] * (n + 1)
    freeCables[start] = 0

    heap = []
    heapq.heappush(heap, (freeCables[start], start))

    while heap:
        currFreeCables, currNode = heapq.heappop(heap)

        if freeCables[currNode] < currFreeCables:
            continue

        for nextNode, dist in graph[currNode]:
            nextFreeCables = currFreeCables
            if base < dist:
                nextFreeCables += 1

            if nextFreeCables < freeCables[nextNode]:
                freeCables[nextNode] = nextFreeCables
                heapq.heappush(heap, (freeCables[nextNode], nextNode))

    return freeCables[n] <= k


n, p, k = map(int, input().split())
graph = defaultdict(list)
for _ in range(p):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

start, end = 0, 1_000_000
answer = -1
while start <= end:
    mid = (start + end) // 2
    if dijkstra(1, mid):
        answer = mid
        end = mid - 1
    else:
        start = mid + 1

print(answer)