import sys

input = sys.stdin.readline

INF = float("inf")


dx = (-1, 0, 1, -1, 0, 1, -1, 0, 1)
dy = (1, 1, 1, 0, 0, 0, -1, -1, -1)


n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

jongsuX = None
jongsuY = None
michin = []

for i in range(n):
    for j in range(m):
        if board[i][j] == "I":
            jongsuX = j
            jongsuY = i
            board[i][j] = "."
        elif board[i][j] == "R":
            michin.append((i, j))
            board[i][j] = "."

moves = list(map(int, input().strip()))
flag = True

for t in range(1, len(moves) + 1):
    move = moves[t - 1]

    jongsuX += dx[move - 1]
    jongsuY += dy[move - 1]

    if (jongsuY, jongsuX) in michin:
        print("kraj", t)
        flag = False
        break

    newMichin = []
    for y, x in michin:
        minDir = -1
        _min = INF
        for i in range(9):
            ny = y + dy[i]
            nx = x + dx[i]
            d = abs(ny - jongsuY) + abs(nx - jongsuX)
            if d < _min:
                _min = d
                minDir = i
        newMichin.append((y + dy[minDir], x + dx[minDir]))

    if (jongsuY, jongsuX) in newMichin:
        print("kraj", t)
        flag = False
        break

    count = [[0] * m for _ in range(n)]
    for y, x in newMichin:
        count[y][x] += 1

    michin = []
    for y in range(n):
        for x in range(m):
            if count[y][x] == 1:
                michin.append((y, x))

if flag:
    board[jongsuY][jongsuX] = "I"
    for y, x in michin:
        board[y][x] = "R"
    for row in board:
        print("".join(row))