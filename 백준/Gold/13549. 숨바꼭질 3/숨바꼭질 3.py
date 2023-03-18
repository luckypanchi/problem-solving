"""
https://www.acmicpc.net/board/view/38887#comment-69010
"""


import sys
from collections import deque

input = sys.stdin.readline
INF = float("inf")
MAX = 100001


def bfs():
    global answer

    que = deque()
    visited = [False] * MAX
    que.append((n, 0))
    visited[n] = True

    while que:
        curr, cnt = que.popleft()

        if curr == k:
            answer = min(answer, cnt)

        if 2 * curr < MAX and not visited[2 * curr]:
            visited[2 * curr] = True
            que.append((2 * curr, cnt))

        for nxt in [curr - 1, curr + 1]:
            if 0 <= nxt < MAX and not visited[nxt]:
                visited[nxt] = True
                que.append((nxt, cnt + 1))


n, k = map(int, input().split())
answer = INF
bfs()

print(answer)