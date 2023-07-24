import sys

input = sys.stdin.readline


dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

answer = 0
visited = [[False] * m for _ in range(n)]

total = n * m


def check(y, x):
    return 0 <= y < n and 0 <= x < m and not visited[y][x]


def dfs(idx, prev):
    global answer

    if n * m == idx:
        answer = max(answer, prev)
        return

    y = idx // m
    x = idx % m

    if not visited[y][x]:
        s = 2 * board[y][x]
        for i in range(4):
            ny1 = y + dy[i]
            nx1 = x + dx[i]
            ny2 = y + dy[(i + 1) % 4]
            nx2 = x + dx[(i + 1) % 4]

            if check(ny1, nx1) and check(ny2, nx2):
                visited[y][x] = True
                visited[ny1][nx1] = True
                visited[ny2][nx2] = True
                dfs(idx + 1, prev + s + board[ny1][nx1] + board[ny2][nx2])
                visited[y][x] = False
                visited[ny1][nx1] = False
                visited[ny2][nx2] = False

    dfs(idx + 1, prev)


dfs(0, 0)


print(answer)