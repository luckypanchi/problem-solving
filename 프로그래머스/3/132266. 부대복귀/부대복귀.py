from collections import defaultdict
import heapq

INF = float("inf")


def solution(n, roads, sources, destination):
    graph = defaultdict(list)
    for a, b in roads:
        graph[a].append(b)
        graph[b].append(a)

    distances = [INF] * (n + 1)
    distances[destination] = 0

    def dijkstra(start):
        heap = []
        heap.append((0, start))
        while heap:
            dist, curr = heapq.heappop(heap)

            if distances[curr] < dist:
                continue

            for nextNode in graph[curr]:
                d = dist + 1
                if d < distances[nextNode]:
                    distances[nextNode] = d
                    heapq.heappush(heap, (d, nextNode))

    dijkstra(destination)
    answer = []
    for source in sources:
        if distances[source] == INF:
            answer.append(-1)
        else:
            answer.append(distances[source])

    return answer
