from collections import defaultdict
import heapq

INF = float("inf")


def dijkstra(N, graph, start):
    heap = []
    distances = [INF] * (N + 1)

    distances[start] = 0
    heapq.heappush(heap, (distances[start], start))

    while heap:
        currDist, currNode = heapq.heappop(heap)

        if distances[currNode] < currDist:
            continue

        for nextNode, dist in graph[currNode]:
            nextDist = currDist + dist
            if nextDist < distances[nextNode]:
                distances[nextNode] = nextDist
                heapq.heappush(heap, (nextDist, nextNode))

    return distances


def solution(N, road, K):
    graph = defaultdict(list)
    for a, b, c in road:
        graph[a].append((b, c))
        graph[b].append((a, c))

    distances = dijkstra(N, graph, 1)

    answer = 0
    for i in range(1, N + 1):
        if distances[i] <= K:
            answer += 1

    return answer