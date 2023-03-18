import sys
import heapq

input = sys.stdin.readline

INF = int(1e9)


n, m, x = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def dijkstra(start):
    dist = [INF] * (n + 1)
    que = []
    heapq.heappush(que, (0, start))
    dist[start] = 0

    while que:
        d, curr = heapq.heappop(que)
        if dist[curr] < d:
            continue

        for i in graph[curr]:
            cost = d + i[1]
            if cost < dist[i[0]]:
                dist[i[0]] = cost
                heapq.heappush(que, (cost, i[0]))
    
    return dist

answer = -INF
back = dijkstra(x)
for i in range(1, n + 1):
    s = dijkstra(i)
    answer = max(answer, s[x] + back[i])

print(answer)