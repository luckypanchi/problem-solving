import sys

sys.setrecursionlimit(10**6)

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [[-1] * m for _ in range(n)]


def dfs(y, x):
    if y == n - 1 and x == m - 1:
        return 1

    if dp[y][x] != -1:
        return dp[y][x]

    dp[y][x] = 0

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < m and board[ny][nx] < board[y][x]:
            dp[y][x] += dfs(ny, nx)

    return dp[y][x]


print(dfs(0, 0))
