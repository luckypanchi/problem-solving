import sys

input = sys.stdin.readline

dx = (1, 0)
dy = (0, 1)


def init(n):
    board = [[0] * 9 for _ in range(9)]
    tiles = [[True] * 10 for _ in range(10)]
    for i in range(10):
        tiles[i][i] = False

    for _ in range(n):
        a, b, c, d = input().split()
        a = int(a)
        c = int(c)

        tiles[a][c] = False
        tiles[c][a] = False
        board[ord(b[0]) - ord("A")][int(b[1]) - 1] = a
        board[ord(d[0]) - ord("A")][int(d[1]) - 1] = c

    locs = list(input().split())
    for i in range(9):
        loc = list(locs[i])
        loc[0] = ord(loc[0]) - ord("A")
        loc[1] = int(loc[1])
        board[loc[0]][loc[1] - 1] = i + 1

    return board, tiles


def get_cands(y, x):
    flags = [True] * 10

    for i in range(9):
        flags[board[i][x]] = False

    for i in range(9):
        flags[board[y][i]] = False

    sy = y // 3 * 3
    sx = x // 3 * 3

    for i in range(sy, sy + 3):
        for j in range(sx, sx + 3):
            flags[board[i][j]] = False

    return [i for i in range(1, 10) if flags[i]]


def dfs(idx):
    if idx == len(empty):
        for row in board:
            print("".join(map(str, row)))
        return True

    y, x = empty[idx]

    if board[y][x] != 0:
        return dfs(idx + 1)

    cands1 = get_cands(y, x)
    for i in range(2):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < 9 and 0 <= ny < 9 and board[ny][nx] == 0:
            cands2 = get_cands(ny, nx)

            for c1 in cands1:
                for c2 in cands2:
                    if tiles[c1][c2]:
                        tiles[c1][c2] = False
                        tiles[c2][c1] = False
                        board[y][x] = c1
                        board[ny][nx] = c2
                        result = dfs(idx + 1)
                        board[ny][nx] = 0
                        board[y][x] = 0
                        tiles[c1][c2] = True
                        tiles[c2][c1] = True
                        if result:
                            return True


no = 1

while True:
    n = int(input())

    if n == 0:
        break

    board, tiles = init(n)
    empty = []
    for i in range(9):
        for j in range(9):
            if board[i][j] == 0:
                empty.append((i, j))

    print("Puzzle", no)
    no += 1

    dfs(0)