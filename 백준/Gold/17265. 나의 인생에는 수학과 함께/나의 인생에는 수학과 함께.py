import sys

input = sys.stdin.readline

INF = float("inf")

dx = (0, 1)
dy = (1, 0)


n = int(input())
board = [list(input().split()) for _ in range(n)]

min_answer = INF
max_answer = -INF


def dfs(y, x, _sum):
    global min_answer, max_answer

    if (y, x) == (n - 1, n - 1):
        max_answer = max(max_answer, _sum)
        min_answer = min(min_answer, _sum)
        return

    for i in range(2):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < n:
            if board[ny][nx] in ("+", "-", "*"):
                dfs(ny, nx, _sum)
            else:
                num = int(board[ny][nx])
                if board[y][x] == "+":
                    dfs(ny, nx, _sum + num)
                elif board[y][x] == "-":
                    dfs(ny, nx, _sum - num)
                elif board[y][x] == "*":
                    dfs(ny, nx, _sum * num)


dfs(0, 0, int(board[0][0]))

print(max_answer, min_answer)