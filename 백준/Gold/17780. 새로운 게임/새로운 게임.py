import sys

input = sys.stdin.readline

dx = (1, -1, 0, 0)
dy = (0, 0, -1, 1)


def checkRange(y, x):
    return 0 <= y < n and 0 <= x < n


def turn(d):
    if 0 <= d < 2:
        return 1 - d
    elif 2 <= d < 4:
        return 5 - d


def move(horseIndex, previous=False):
    y, x, d = horses[horseIndex]
    ny = y + dy[d]
    nx = x + dx[d]

    if checkRange(ny, nx) and boardStatus[ny][nx] == 0:
        board[ny][nx].extend(board[y][x])

        for i in board[y][x]:
            horses[i][0] = ny
            horses[i][1] = nx
        board[y][x].clear()

    elif checkRange(ny, nx) and boardStatus[ny][nx] == 1:
        board[ny][nx].extend(board[y][x][::-1])

        for i in board[y][x]:
            horses[i][0] = ny
            horses[i][1] = nx
        board[y][x].clear()

    elif (checkRange(ny, nx) and boardStatus[ny][nx] == 2) or not checkRange(ny, nx):
        if previous:
            return True

        horses[horseIndex][2] = turn(d)
        return move(horseIndex, True)

    if len(board[ny][nx]) >= 4:
        return False
    else:
        return True


n, k = map(int, input().split())
boardStatus = [list(map(int, input().split())) for _ in range(n)]
board = [[[] for _ in range(n)] for _ in range(n)]
horses = []
for i in range(k):
    a, b, c = map(int, input().split())
    board[a - 1][b - 1].append(i)
    horses.append([a - 1, b - 1, c - 1])

round = 0

while round <= 1000:
    round += 1

    for horseIndex in range(k):
        y, x, d = horses[horseIndex]

        if len(board[y][x]) > 0 and horseIndex == board[y][x][0]:
            flag = move(horseIndex)

            if not flag:
                print(round)
                sys.exit()
print(-1)