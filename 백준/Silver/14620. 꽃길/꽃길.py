import sys

input = sys.stdin.readline

INF = float("inf")

dx = (0, 1, 0, -1, 0)
dy = (0, 0, 1, 0, -1)


def get_cost_and_mark(y, x):
    for i in range(5):
        ny = y + dy[i]
        nx = x + dx[i]
        if visited[ny][nx]:
            return -1

    c = 0
    for i in range(5):
        ny = y + dy[i]
        nx = x + dx[i]
        c += board[ny][nx]
        visited[ny][nx] = True

    return c


def unmark(y, x):
    for i in range(5):
        ny = y + dy[i]
        nx = x + dx[i]
        visited[ny][nx] = False


def dfs(cnt, cost):
    global answer

    if cnt == 3:
        answer = min(answer, cost)
        return

    for y in range(1, n - 1):
        for x in range(1, n - 1):
            c = get_cost_and_mark(y, x)
            if c == -1:
                continue

            dfs(cnt + 1, cost + c)
            unmark(y, x)


n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]


answer = INF
dfs(0, 0)

print(answer)
