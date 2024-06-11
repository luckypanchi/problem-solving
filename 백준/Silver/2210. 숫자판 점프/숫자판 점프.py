import sys

input = sys.stdin.readline


dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def dfs(prev, startY, startX):
    if len(prev) == 6:
        results.add(int(prev))
        return

    for i in range(4):
        ny = startY + dy[i]
        nx = startX + dx[i]
        if 0 <= ny < 5 and 0 <= nx < 5:
            dfs(prev + board[ny][nx], ny, nx)


board = [list(input().split()) for _ in range(5)]
results = set()

for y in range(5):
    for x in range(5):
        dfs(board[y][x], y, x)

print(len(results))