import sys
from collections import deque

input = sys.stdin.readline


def bfs():
    que = deque()
    visited = [0] * 100001
    que.append(n)
    visited[n] = 1

    while que:
        curr = que.popleft()

        if curr == m:
            return visited[curr] - 1

        for nxt in [curr + 1, curr - 1, curr + a, curr - a, curr + b, curr - b, curr * a, curr * b]:
            if 0 <= nxt < 100001 and visited[nxt] == 0:
                visited[nxt] = visited[curr] + 1
                que.append(nxt)


a, b, n, m = map(int, input().split())

print(bfs())