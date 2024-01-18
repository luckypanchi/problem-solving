import sys
from collections import defaultdict, deque

input = sys.stdin.readline


def bfs(start, dest):
    que = deque()
    visited = [-1] * (n + 1)

    que.append(start)
    visited[start] = 0

    while que:
        curr = que.popleft()

        for _next, d in graph[curr]:
            if visited[_next] == -1:
                visited[_next] = d + visited[curr]

                if _next == dest:
                    return visited[_next]
                else:
                    que.append(_next)


n, m = map(int, input().split())
graph = defaultdict(list)
for _ in range(n - 1):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

for _ in range(m):
    start, dest = map(int, input().split())
    print(bfs(start, dest))