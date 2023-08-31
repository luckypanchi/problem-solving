import sys

input = sys.stdin.readline

dx = (1, -1, 0, 0)
dy = (0, 0, 1, -1)


def dfs(y, x, cnt, percent):
    global answer
    if cnt == n:
        answer += percent
        return

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < 2 * n + 1 and 0 <= nx < 2 * n + 1 and not visited[ny][nx]:
            visited[ny][nx] = True
            dfs(ny, nx, cnt + 1, percent * p[i])
            visited[ny][nx] = False


_input = list(map(int, input().split()))
n = _input[0]
p = list(map(lambda x: x * 0.01, _input[1:]))

visited = [[False] * (2 * n + 1) for _ in range(2 * n + 1)]
sy, sx = n, n
visited[sy][sx] = True

answer = 0
dfs(sy, sx, 0, 1)

print(answer)