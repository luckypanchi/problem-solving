import sys
from collections import defaultdict, deque

sys.setrecursionlimit(10**6)

input = sys.stdin.readline


n, m = map(int, input().split())
boss = list(map(int, input().split()))

results = [0] * (n + 1)
graph = defaultdict(list)

for i in range(1, n):
    graph[boss[i]].append(i + 1)

for _ in range(m):
    a, b = map(int, input().split())
    results[a] += b


def bfs(start):
    visited = [False] * (n + 1)
    que = deque()

    que.append(start)

    while que:
        curr = que.popleft()
        if not visited[curr]:
            visited[curr] = True
            for nextIdx in graph[curr]:
                if not visited[nextIdx]:
                    que.append(nextIdx)
                    results[nextIdx] += results[curr]


bfs(1)


print(*results[1:])