import sys
from collections import defaultdict

sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(node):
    global cnt

    for nxt in graph[node]:
        if visited[nxt] == 0:
            visited[nxt] = cnt
            cnt += 1
            dfs(nxt)


n, m, r = map(int, input().split())
graph = defaultdict(list)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    graph[i].sort(reverse=True)

visited = [0] * (n + 1)
visited[r] = 1
cnt = 2
dfs(r)

for i in range(1, n + 1):
    print(visited[i])