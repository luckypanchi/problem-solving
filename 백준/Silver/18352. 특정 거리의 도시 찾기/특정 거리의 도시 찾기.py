import sys, heapq

input = sys.stdin.readline
INF = int(1e9)


n, m, k, x = map(int, input().split())
nodes = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    nodes[a].append(b)
distance = [INF] * (n + 1)


def dijkstra(start):
    que = []
    heapq.heappush(que, (0, start))
    distance[start] = 0
    while que:
        dist, now = heapq.heappop(que)
        if distance[now] < dist:
            continue
        for i in nodes[now]:
            cost = dist + 1
            if cost < distance[i]:
                distance[i] = cost
                heapq.heappush(que, (cost, i))


dijkstra(x)

answer = []
for i in range(1, n + 1):
    if distance[i] == k:
        answer.append(i)

if len(answer) == 0:
    print(-1)
else:
    for a in answer:
        print(a)
