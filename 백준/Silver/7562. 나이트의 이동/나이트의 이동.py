import sys
from collections import deque

input = sys.stdin.readline

dy = (-1, -2, -2, -1, 1, 2, 2, 1)
dx = (2, 1, -1, -2, -2, -1, 1, 2)


def bfs():
    visited = [[-1] * n for _ in range(n)]
    que = deque()

    visited[startY][startX] = 0
    que.append((startY, startX))

    while que:
        y, x = que.popleft()

        if (y, x) == (destY, destX):
            return visited[y][x]

        for i in range(8):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < n and visited[ny][nx] == -1:
                visited[ny][nx] = visited[y][x] + 1
                que.append((ny, nx))


tc = int(input())
for _ in range(tc):
    n = int(input())
    startY, startX = map(int, input().split())
    destY, destX = map(int, input().split())
    print(bfs())