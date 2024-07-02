import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline

INF = float("inf")


def dijkstra(startList):
    heap = []
    dist = [INF] * (n + 1)

    for start in startList:
        heapq.heappush(heap, (0, start))
        dist[start] = 0

    while heap:
        cost, curr = heapq.heappop(heap)

        if dist[curr] < cost:
            continue

        for nextNode, d in graph[curr]:
            totalCost = d + cost
            if totalCost < dist[nextNode]:
                dist[nextNode] = totalCost
                heapq.heappush(heap, (totalCost, nextNode))

    return dist


n, m, k = map(int, input().split())
graph = defaultdict(list)
for _ in range(m):
    a, b, t = map(int, input().split())
    graph[a].append((b, t))
    graph[b].append((a, t))
followers = list(map(int, input().split()))

followersDist = dijkstra(followers)
chaewonDist = dijkstra([1])

answer = []
for node in range(2, n + 1):
    if chaewonDist[node] < followersDist[node]:
        answer.append(node)

if len(answer) == 0:
    print(0)
else:
    print(*answer, sep="\n")