import sys
from itertools import product

input = sys.stdin.readline
INF = int(1e9)


fdx = (-1, -1, 0, 1, 1, 1, 0, -1)
fdy = (0, -1, -1, -1, 0, 1, 1, 1)

sdx = (0, -1, 0, 1)
sdy = (-1, 0, 1, 0)


def make_copy():
    for i in range(4):
        for j in range(4):
            for k in range(8):
                copy[i][j][k] = board[i][j][k]


def fish_move():
    global board

    tmp = [[[0] * 8 for _ in range(4)] for _ in range(4)]

    for i in range(4):
        for j in range(4):
            for d in range(8):
                if board[i][j][d] != 0:
                    di = d
                    for _ in range(8):
                        ny = i + fdy[di]
                        nx = j + fdx[di]
                        if 0 <= ny < 4 and 0 <= nx < 4 and smell[ny][nx] == 0 and (ny, nx) != (sy, sx):
                            tmp[ny][nx][di] += board[i][j][d]
                            break
                        else:
                            di = (di - 1) % 8
                    else:
                        tmp[i][j][d] += board[i][j][d]

    board = tmp


def shark_move():
    global sy, sx

    eat = []
    max_cnt = -INF
    fy, fx = sy, sx

    tmp_board = [[[0] * 8 for _ in range(4)] for _ in range(4)]

    for dirs in shark_dirs:

        for i in range(4):
            for j in range(4):
                for k in range(8):
                    tmp_board[i][j][k] = board[i][j][k]

        tmp_eat = []
        tmp_cnt = 0
        tmp_y, tmp_x = sy, sx
        for d in dirs:
            ny = tmp_y + sdy[d]
            nx = tmp_x + sdx[d]
            if 0 <= ny < 4 and 0 <= nx < 4:
                if sum(tmp_board[ny][nx]) != 0:
                    tmp_eat.append((ny, nx))
                    tmp_cnt += sum(tmp_board[ny][nx])
                    tmp_board[ny][nx] = [0] * 8
                tmp_y, tmp_x = ny, nx
            else:
                tmp_cnt = -INF
                break

        if max_cnt < tmp_cnt:
            max_cnt = tmp_cnt
            eat = tmp_eat
            fy, fx = tmp_y, tmp_x

    sy, sx = fy, fx
    for y, x in eat:
        board[y][x] = [0] * 8
        smell[y][x] = 3


def decrease_smell():
    for i in range(4):
        for j in range(4):
            if smell[i][j] > 0:
                smell[i][j] -= 1


def apply_copy():
    for i in range(4):
        for j in range(4):
            for k in range(8):
                board[i][j][k] += copy[i][j][k]


m, s = map(int, input().split())
board = [[[0] * 8 for _ in range(4)] for _ in range(4)]
for _ in range(m):
    y, x, d = map(int, input().split())
    board[y - 1][x - 1][d - 1] += 1
sy, sx = map(int, input().split())
sy -= 1
sx -= 1

shark_dirs = list(product(range(4), range(4), range(4)))
smell = [[0] * 4 for _ in range(4)]

for _ in range(s):

    copy = [[[0] * 8 for _ in range(4)] for _ in range(4)]

    make_copy()
    fish_move()
    shark_move()
    decrease_smell()
    apply_copy()


answer = 0
for i in range(4):
    for j in range(4):
        answer += sum(board[i][j])


print(answer)