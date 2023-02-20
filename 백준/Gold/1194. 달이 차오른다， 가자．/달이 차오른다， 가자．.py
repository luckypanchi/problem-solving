import sys
from collections import deque


input = sys.stdin.readline
dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def has_key(key, s):
    return key & (1 << (ord(s) - ord("A")))


def bfs(sy, sx):
    dist = [[[0] * m for _ in range(n)] for _ in range(1 << 6)]
    dist[0][sy][sx] = 1
    que = deque([(sy, sx, 0)])
    results = []

    while que:
        y, x, key = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (
                0 <= nx < m
                and 0 <= ny < n
                and board[ny][nx] != "#"
                and dist[key][ny][nx] == 0
            ):
                if board[ny][nx] == "1":
                    results.append(dist[key][y][x] + 1)
                elif board[ny][nx] == ".":
                    dist[key][ny][nx] = dist[key][y][x] + 1
                    que.append((ny, nx, key))
                elif board[ny][nx] in "abcdef":
                    new_key = key | (1 << (ord(board[ny][nx]) - ord("a")))
                    dist[new_key][ny][nx] = dist[key][y][x] + 1
                    que.append((ny, nx, new_key))
                elif board[ny][nx] in "ABCDEF" and has_key(key, board[ny][nx]):
                    dist[key][ny][nx] = dist[key][y][x] + 1
                    que.append((ny, nx, key))

    return results


n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

sy, sx = None, None
for i in range(n):
    for j in range(m):
        if board[i][j] == "0":
            board[i][j] = "."
            sy, sx = i, j

results = bfs(sy, sx)
if len(results) == 0:
    print(-1)
else:
    results.sort()
    print(results[0] - 1)