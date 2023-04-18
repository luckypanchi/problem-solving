import sys

input = sys.stdin.readline


def get_cands(y, x):
    flag = [True] * 10

    for i in range(9):
        flag[board[i][x]] = False

    for i in range(9):
        flag[board[y][i]] = False

    sy = y // 3 * 3
    sx = x // 3 * 3

    for i in range(sy, sy + 3):
        for j in range(sx, sx + 3):
            flag[board[i][j]] = False

    return [i for i in range(1, 10) if flag[i]]


def dfs(idx):
    if idx == len(empty):
        for row in board:
            print(*row)
        sys.exit()

    y, x = empty[idx]
    cands = get_cands(y, x)

    for cand in cands:
        board[y][x] = cand
        dfs(idx + 1)
        board[y][x] = 0


board = [list(map(int, input().split())) for _ in range(9)]
empty = []
for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            empty.append((i, j))


dfs(0)