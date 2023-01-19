import sys

input = sys.stdin.readline

dy = [-1, 0, 1]


def go(y, x):
    visited[y][x] = True
    if x == c - 1:
        return 1

    for i in range(3):
        ny = y + dy[i]
        nx = x + 1
        if 0 <= ny < r and board[ny][nx] == "." and visited[ny][nx] is False:
            if go(ny, nx):
                return 1
    return 0


r, c = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]
visited = [[False] * c for _ in range(r)]

answer = 0

for y in range(r):
    if board[y][0] == ".":
        answer += go(y, 0)

print(answer)
