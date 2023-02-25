import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def bfs(sy, sx):
    que = deque([(sy, sx)])
    dist = [[0] * m for _ in range(n)]
    dist[sy][sx] = 1

    while que:
        y, x = que.popleft()

        for i in range(4):
            for t in range(1, k + 1):
                ny = y + t * dy[i]
                nx = x + t * dx[i]

                if not (0 <= ny < n and 0 <= nx < m and board[ny][nx] == "."):
                    break

                if dist[ny][nx] == 0:
                    if (ny, nx) == (dest_y, dest_x):
                        return dist[y][x]
                    dist[ny][nx] = dist[y][x] + 1
                    que.append((ny, nx))
                elif dist[ny][nx] <= dist[y][x]:
                    break

    return -1


n, m, k = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]
start_y, start_x, dest_y, dest_x = map(int, input().split())

start_y -= 1
start_x -= 1
dest_y -= 1
dest_x -= 1

answer = bfs(start_y, start_x)
print(answer)