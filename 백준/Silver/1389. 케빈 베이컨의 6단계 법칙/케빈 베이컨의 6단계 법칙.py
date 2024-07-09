import sys
from collections import defaultdict, deque

input = sys.stdin.readline

INF = float("inf")


def bfs(start):
    que = deque()
    dist = [-1] * (n + 1)

    que.append(start)
    dist[start] = 0

    while que:
        curr = que.popleft()

        for nextNode in graph[curr]:
            if dist[nextNode] == -1:
                dist[nextNode] = dist[curr] + 1
                que.append(nextNode)

    return dist


n, m = map(int, input().split())
graph = defaultdict(list)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


minValue = INF
answer = -1
for start in range(1, n + 1):
    dist = bfs(start)
    v = sum(dist[1:])
    if v < minValue:
        minValue = v
        answer = start

print(answer)