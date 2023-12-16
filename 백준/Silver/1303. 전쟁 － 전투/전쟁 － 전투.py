import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def mark(y, x, color):
    que = deque()
    que.append((y, x))
    visited[y][x] = True
    count = 1

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx] and board[ny][nx] == color:
                visited[ny][nx] = True
                que.append((ny, nx))
                count += 1

    return count**2


m, n = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

blue = 0
white = 0

visited = [[False] * m for _ in range(n)]

for y in range(n):
    for x in range(m):
        if not visited[y][x]:
            power = mark(y, x, board[y][x])
            if board[y][x] == "W":
                white += power
            else:
                blue += power

print(white, blue)