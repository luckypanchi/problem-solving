from collections import defaultdict
import heapq

INF = float("inf")


def solution(n, s, a, b, fares):
    graph = defaultdict(list)
    for c, d, f in fares:
        graph[c].append((d, f))
        graph[d].append((c, f))

    def dijkstra(start):
        distances = [INF] * (n + 1)
        distances[start] = 0

        h = []
        heapq.heappush(h, (distances[start], start))

        while h:
            currCost, curr = heapq.heappop(h)

            if distances[curr] < currCost:
                continue

            for nextNode, cost in graph[curr]:
                totalCost = currCost + cost
                if totalCost < distances[nextNode]:
                    distances[nextNode] = totalCost
                    heapq.heappush(h, (totalCost, nextNode))

        return distances

    distFromStart = dijkstra(s)
    distFromA = dijkstra(a)
    distFromB = dijkstra(b)

    answer = INF
    for i in range(1, n + 1):
        answer = min(answer, distFromStart[i] + distFromA[i] + distFromB[i])

    return answer
