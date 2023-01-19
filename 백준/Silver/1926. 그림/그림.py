import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, -1, 0, 1)


n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

paints = 0
max_size = 0


def dfs(y, x):
    cnt = 1
    stack = []
    stack.append((y, x))
    matrix[y][x] = 0
    while stack:
        y, x = stack.pop()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and matrix[ny][nx] == 1:
                cnt += 1
                matrix[ny][nx] = 0
                stack.append((ny, nx))
    return cnt


for i in range(n):
    for j in range(m):
        if matrix[i][j] == 1:
            paints += 1
            max_size = max(max_size, dfs(i, j))


print(paints)
print(max_size)
