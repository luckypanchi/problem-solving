import sys
from collections import deque

input = sys.stdin.readline
dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def bfs():
    que = deque([(0, 0, 0)])
    dist = [[[0] * (k + 1) for _ in range(m)] for _ in range(n)]
    dist[0][0][0] = 1

    while que:
        y, x, cnt = que.popleft()

        if (y, x) == (n - 1, m - 1):
            return dist[y][x][cnt]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n:
                if board[ny][nx] == 0 and dist[ny][nx][cnt] == 0:
                    dist[ny][nx][cnt] = dist[y][x][cnt] + 1
                    que.append((ny, nx, cnt))
                elif board[ny][nx] == 1 and cnt < k and dist[ny][nx][cnt + 1] == 0:
                    dist[ny][nx][cnt + 1] = dist[y][x][cnt] + 1
                    que.append((ny, nx, cnt + 1))

    return -1


n, m, k = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]

answer = bfs()

print(answer)