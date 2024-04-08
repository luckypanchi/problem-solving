import sys
from collections import defaultdict, deque

input = sys.stdin.readline


def bfs():
    que = deque()
    visited = [0] * (n + 1)
    pipeVisited = [False] * (m + 1)
    que.append(1)
    visited[1] = 1

    while que:
        curr = que.popleft()

        if curr == n:
            return visited[curr]

        for pipeIndex in graph[curr]:
            if pipeVisited[pipeIndex]:
                continue

            pipeVisited[pipeIndex] = True
            for _next in pipeList[pipeIndex]:
                if visited[_next] != 0:
                    continue

                visited[_next] = visited[curr] + 1
                que.append(_next)

    return -1


n, k, m = map(int, input().split())
graph = defaultdict(list)
pipeList = [[] for _ in range(m + 1)]
for p in range(m):
    pipeList[p + 1] = list(map(int, input().split()))
    for i in pipeList[p + 1]:
        graph[i].append(p + 1)

answer = bfs()

print(answer)
