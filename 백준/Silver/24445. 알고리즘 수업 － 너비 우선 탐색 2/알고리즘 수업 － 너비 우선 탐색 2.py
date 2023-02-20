import sys
from collections import deque, defaultdict


input = sys.stdin.readline


def bfs(start):
    que = deque([start])
    visited[start] = 1
    cnt = 2

    while que:
        node = que.popleft()
        for nxt in graph[node]:
            if visited[nxt] == 0:
                visited[nxt] = cnt
                cnt += 1
                que.append(nxt)


n, m, r = map(int, input().split())
graph = defaultdict(list)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    graph[i].sort(reverse=True)

visited = [0] * (n + 1)
bfs(r)

for i in range(1, n + 1):
    print(visited[i])