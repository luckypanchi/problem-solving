import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    que = deque()
    que.append(start)

    visited = [[-1, 0] for _ in range(100001)]
    visited[start][0] = 0
    visited[start][1] = -1

    while que:
        curr = que.popleft()

        if curr == k:
            return visited

        for nxt in [curr + 1, curr - 1, curr * 2]:
            if 0 <= nxt < 100001 and visited[nxt][0] == -1:
                visited[nxt][0] = visited[curr][0] + 1
                visited[nxt][1] = curr
                que.append(nxt)


n, k = map(int, input().split())

visited = bfs(n)

print(visited[k][0])

answers = []
curr = k
while curr != -1:
    answers.append(curr)
    curr = visited[curr][1]

print(*answers[::-1])