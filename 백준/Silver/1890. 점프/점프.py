import sys

input = sys.stdin.readline

dy = [0, 1]
dx = [1, 0]


n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]

dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

for y in range(n):
    for x in range(n):
        if (y, x) == (n - 1, n - 1):
            print(dp[n - 1][n - 1])
            sys.exit()

        length = matrix[y][x]
        for i in range(2):
            ny = y + dy[i] * length
            nx = x + dx[i] * length
            if 0 <= nx < n and 0 <= ny < n:
                dp[ny][nx] += dp[y][x]
