import sys
import heapq

input = sys.stdin.readline

INF = float("inf")


def dijkstra():
    heap = []
    dist = [INF] * (n + 1)

    heapq.heappush(heap, (0, start))

    while heap:
        cost, curr = heapq.heappop(heap)

        if dist[curr] < cost:
            continue

        for next_cost, next_node in graph[curr]:
            total_cost = cost + next_cost
            if total_cost < dist[next_node]:
                dist[next_node] = total_cost
                prev[next_node] = curr
                heapq.heappush(heap, (total_cost, next_node))

    return dist[dest]


n = int(input())
m = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    s, d, c = map(int, input().split())
    graph[s].append((c, d))

start, dest = map(int, input().split())

prev = [0] * (n + 1)
answer = dijkstra()

path = [dest]
curr = dest
while curr != start:
    curr = prev[curr]
    path.append(curr)

path.reverse()

print(answer)