import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def bfs():
    que = deque()
    que.append((0, 0))

    visited = [[-1] * m for _ in range(n)]
    visited[0][0] = 1

    while que:
        y, x = que.popleft()

        if (y, x) == (n - 1, m - 1):
            return visited[n - 1][m - 1]

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and visited[ny][nx] == -1 and board[ny][nx] == 1:
                visited[ny][nx] = visited[y][x] + 1
                que.append((ny, nx))


n, m = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]

print(bfs())