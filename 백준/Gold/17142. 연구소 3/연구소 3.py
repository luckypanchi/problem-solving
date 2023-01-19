import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline
INF = int(1e9)
dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)

n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

all_virus = []
blank = 0
for i in range(n):
    for j in range(n):
        if matrix[i][j] == 2:
            all_virus.append((i, j))
        if matrix[i][j] == 0:
            blank += 1


def bfs(virus):
    visited = [[-1] * n for _ in range(n)]
    que = deque()
    for y, x in virus:
        que.append((y, x))
        visited[y][x] = 0

    t = 0
    b = blank

    while que:
        y, x = que.popleft()

        if b == 0:
            break

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (
                0 <= ny < n
                and 0 <= nx < n
                and visited[ny][nx] == -1
                and matrix[ny][nx] != 1
            ):
                visited[ny][nx] = visited[y][x] + 1
                t = max(t, visited[ny][nx])
                que.append((ny, nx))
                if matrix[ny][nx] == 0:
                    b -= 1

    if b == 0:
        return t
    else:
        return -1


answer = []

for virus in list(combinations(all_virus, m)):
    result = bfs(virus)
    if 0 <= result:
        answer.append(result)

if len(answer) == 0:
    print(-1)
else:
    print(min(answer))
