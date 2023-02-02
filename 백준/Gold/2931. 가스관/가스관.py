import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def pipe(block, di):
    # if block in ("|", "-", "+"):
    #     return (ddy, ddx)
    #
    # elif block in ("1", "3"):
    #     return (-ddx, -ddy)
    #
    # elif block in ("2", "4"):
    #     return (ddx, ddy)

    if block == "|" and di in (1, 3):
        return di
    elif block == "-" and di in (0, 2):
        return di
    elif block == "+":
        return di
    elif block == "1" and di in (2, 3):
        return 3 - di
    elif block == "2" and di in (1, 2):
        if di == 1:
            return 0
        else:
            return 3
    elif block == "3" and di in (0, 1):
        return 3 - di
    elif block == "4" and di in (0, 3):
        if di == 0:
            return 1
        else:
            return 2
    else:
        return 4


def move(start):
    y, x = start
    di = 0
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < r and 0 <= nx < c and board[ny][nx] not in (".", "M", "Z"):
            y, x = ny, nx
            di = i
            break

    while True:
        di = pipe(board[y][x], di)
        ny = y + dy[di]
        nx = x + dx[di]

        if board[ny][nx] == ".":
            return (y, x, ny, nx)

        y, x = ny, nx


def check(y, x):
    cnt = 0
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < r and 0 <= nx < c and board[ny][nx] != ".":
            if i in (0, 2) and board[ny][nx] not in ("|", "M", "Z"):
                cnt += 1
            if i in (1, 3) and board[ny][nx] not in ("-", "M", "Z"):
                cnt += 1
    if cnt == 4:
        return True
    else:
        return False


r, c = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]

start1, start2 = None, None
for i in range(r):
    for j in range(c):
        if board[i][j] == "M":
            start1 = (i, j)
        if board[i][j] == "Z":
            start2 = (i, j)

dest_y1, dest_x1, ny1, nx1 = move(start1)
dest_y2, dest_x2, ny2, nx2 = move(start2)

di1, di2 = 0, 0
for i in range(4):
    if (dy[i], dx[i]) == (ny1 - dest_y1, nx1 - dest_x1):
        di1 = i
    if (dy[i], dx[i]) == (dest_y2 - ny2, dest_x2 - nx2):
        di2 = i

block = None
if check(ny1, nx1):
    block = "+"
else:
    for b in ("|", "-", "1", "2", "3", "4"):
        di = pipe(b, di1)
        if di == 4:
            continue
        if di == di2:
            block = b
            break

print(ny1 + 1, nx1 + 1, block)