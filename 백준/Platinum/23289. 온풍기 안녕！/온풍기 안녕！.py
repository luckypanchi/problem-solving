import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def heat():
    for y, x, d in heaters:
        ny = y + dy[d]
        nx = x + dx[d]

        if not (0 <= ny < r and 0 <= nx < c):
            continue

        visited = [[False] * c for _ in range(r)]
        que = deque([(ny, nx, 5)])

        while que:
            y, x, temp = que.popleft()

            if temp == 0:
                continue

            board[y][x] += temp

            ny = y + dy[d]
            nx = x + dx[d]
            if (
                0 <= ny < r
                and 0 <= nx < c
                and not visited[ny][nx]
                and {(y, x), (ny, nx)} not in walls
            ):
                visited[ny][nx] = True
                que.append((ny, nx, temp - 1))

            for nd in [(d - 1) % 4, (d + 1) % 4]:
                tmp_y = y + dy[nd]
                tmp_x = x + dx[nd]
                ny = tmp_y + dy[d]
                nx = tmp_x + dx[d]
                if (
                    0 <= ny < r
                    and 0 <= nx < c
                    and not visited[ny][nx]
                    and {(y, x), (tmp_y, tmp_x)} not in walls
                    and {(tmp_y, tmp_x), (ny, nx)} not in walls
                ):
                    visited[ny][nx] = True
                    que.append((ny, nx, temp - 1))


def spread():
    visited = [[False] * c for _ in range(r)]
    ops = [[0] * c for _ in range(r)]
    for y in range(r):
        for x in range(c):
            if board[y][x] != 0:
                visited[y][x] = True
                for i in range(4):
                    ny = y + dy[i]
                    nx = x + dx[i]
                    if (
                        0 <= ny < r
                        and 0 <= nx < c
                        and not visited[ny][nx]
                        and {(y, x), (ny, nx)} not in walls
                    ):
                        diff = abs(board[y][x] - board[ny][nx]) // 4
                        if board[y][x] < board[ny][nx]:
                            ops[y][x] += diff
                            ops[ny][nx] -= diff
                        else:
                            ops[y][x] -= diff
                            ops[ny][nx] += diff

    for y in range(r):
        for x in range(c):
            board[y][x] += ops[y][x]


def decrease_boundary():
    for y in range(r):
        for x in range(c):
            if (y == 0 or x == 0 or y == r - 1 or x == c - 1) and 0 < board[y][x]:
                board[y][x] -= 1


def check_targets():
    for y, x in targets:
        if board[y][x] < k:
            return False
    return True


r, c, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(r)]
heaters = []
targets = []
for i in range(r):
    for j in range(c):
        if board[i][j] == 1:
            heaters.append((i, j, 0))
        elif board[i][j] == 4:
            heaters.append((i, j, 1))
        elif board[i][j] == 2 or board[i][j] == 3:
            heaters.append((i, j, board[i][j]))
        elif board[i][j] == 5:
            targets.append((i, j))

w = int(input())
walls = []
for _ in range(w):
    y, x, t = map(int, input().split())
    y -= 1
    x -= 1
    if t == 0:
        walls.append({(y, x), (y - 1, x)})
    elif t == 1:
        walls.append({(y, x), (y, x + 1)})


board = [[0] * c for _ in range(r)]

chocolates = 0

while True:
    heat()
    spread()
    decrease_boundary()
    chocolates += 1
    if check_targets():
        break
    if chocolates > 100:
        chocolates = 101
        break

print(chocolates)