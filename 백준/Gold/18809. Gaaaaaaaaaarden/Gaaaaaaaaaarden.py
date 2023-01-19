import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def go(green, red):
    visited = [[0] * m for _ in range(n)]
    que = deque()
    for y, x in green:
        visited[y][x] = 1
        que.append((y, x))
    for y, x in red:
        visited[y][x] = -1
        que.append((y, x))
    cnt = 0
    while que:
        y, x = que.popleft()
        if visited[y][x] == "X":
            continue
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (
                0 <= ny < n
                and 0 <= nx < m
                and matrix[ny][nx] != 0
                and visited[ny][nx] != "X"
            ):
                if visited[y][x] < 0:
                    ntime = visited[y][x] - 1
                elif visited[y][x] > 0:
                    ntime = visited[y][x] + 1

                if visited[ny][nx] != 0:
                    if ntime + visited[ny][nx] == 0:
                        cnt += 1
                        visited[ny][nx] = "X"
                else:
                    visited[ny][nx] = ntime
                    que.append((ny, nx))

    return cnt


n, m, g, r = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

availables = []

for i in range(n):
    for j in range(m):
        if matrix[i][j] == 2:
            availables.append((i, j))

answer = 0

for tmp in map(list, combinations(availables, g + r)):
    for green in map(list, combinations(tmp, g)):
        red = [item for item in tmp if item not in green]
        answer = max(answer, go(green, red))


print(answer)
