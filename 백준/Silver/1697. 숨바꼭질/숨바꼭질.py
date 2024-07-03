import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    que = deque()
    que.append(start)

    visited = [-1] * 100001
    visited[start] = 0

    while que:
        curr = que.popleft()

        if curr == k:
            return visited[curr]

        for nxt in [curr + 1, curr - 1, curr * 2]:
            if 0 <= nxt < 100001 and visited[nxt] == -1:
                visited[nxt] = visited[curr] + 1
                que.append(nxt)


n, k = map(int, input().split())

answer = bfs(n)

print(answer)