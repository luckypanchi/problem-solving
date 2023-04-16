import sys

input = sys.stdin.readline

dx = (1, 1, 0, -1, -1, -1, 0, 1)
dy = (0, 1, 1, 1, 0, -1, -1, -1)


def mark(y, x):
    marked = []

    visited[y][x] = True
    marked.append((y, x))

    for i in range(8):
        ny = y
        nx = x
        while 0 <= ny + dy[i] < n and 0 <= nx + dx[i] < n:
            ny += dy[i]
            nx += dx[i]
            if not visited[ny][nx]:
                visited[ny][nx] = True
                marked.append((ny, nx))

    return marked


def unmark(marked):
    for y, x in marked:
        visited[y][x] = False


def dfs(row):
    global answer

    if row == n:
        answer += 1
        return

    for i in range(n):
        if not visited[row][i]:
            marked = mark(row, i)
            dfs(row + 1)
            unmark(marked)


n = int(input())

visited = [[False] * n for _ in range(n)]

answer = 0

dfs(0)

print(answer)