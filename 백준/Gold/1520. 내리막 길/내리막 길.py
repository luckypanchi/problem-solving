import sys

input = sys.stdin.readline

INF = float("inf")

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def solve(curr):
    if curr == n * m - 1:
        return 1

    if dp[curr] != -1:
        return dp[curr]

    y = curr // m
    x = curr % m

    result = 0
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]

        if 0 <= ny < n and 0 <= nx < m and board[ny][nx] < board[y][x]:
            next = ny * m + nx
            result += solve(next)

    dp[curr] = result
    return dp[curr]


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [-1] * (n * m)

print(solve(0))