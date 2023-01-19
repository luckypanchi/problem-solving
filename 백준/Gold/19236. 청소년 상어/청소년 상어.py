import sys
from copy import deepcopy

input = sys.stdin.readline

dx = (0, -1, -1, -1, 0, 1, 1, 1)
dy = (-1, -1, 0, 1, 1, 1, 0, -1)

answer = 0


def move(matrix, fish, shark):
    sy, sx, _ = shark

    for idx, f in enumerate(fish):
        if f is False:
            continue

        y, x, d = f
        for _ in range(8):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < 4 and 0 <= ny < 4 and (ny, nx) != (sy, sx):
                if matrix[ny][nx] is False:
                    fish[idx] = (ny, nx, d)
                    matrix[ny][nx] = idx
                    matrix[y][x] = False
                else:
                    nidx = matrix[ny][nx]
                    ny, nx, nd = fish[nidx]
                    matrix[y][x] = nidx
                    matrix[ny][nx] = idx
                    fish[idx] = (ny, nx, d)
                    fish[nidx] = (y, x, nd)
                break
            else:
                d = (d + 1) % 8


def solve(matrix, fish, shark, SUM):
    global answer

    move(matrix, fish, shark)

    sy, sx, sd = shark
    flag = True

    for i in range(1, 4):
        ny = sy + i * dy[sd]
        nx = sx + i * dx[sd]
        if 0 <= ny < 4 and 0 <= nx < 4 and matrix[ny][nx] is not False:
            nmatrix = deepcopy(matrix)
            nfish = deepcopy(fish)
            nshark = deepcopy(shark)

            idx = matrix[ny][nx]
            nshark = deepcopy(nfish[idx])
            nfish[idx] = False
            nmatrix[ny][nx] = False

            solve(nmatrix, nfish, nshark, SUM + idx + 1)

            flag = False

    if flag:
        answer = max(SUM, answer)


def main():
    global answer

    fish = [0] * 16

    matrix = [[0] * 4 for _ in range(4)]

    for i in range(4):
        tmp = list(map(lambda x: int(x) - 1, input().split()))
        for j in range(4):
            idx = tmp[2 * j]
            d = tmp[2 * j + 1]
            matrix[i][j] = idx
            fish[idx] = (i, j, d)

    idx = matrix[0][0]
    shark = deepcopy(fish[idx])
    fish[idx] = False
    matrix[0][0] = False

    solve(matrix, fish, shark, idx + 1)

    print(answer)


main()
