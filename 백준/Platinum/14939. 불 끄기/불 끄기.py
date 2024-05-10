import sys

input = sys.stdin.readline

INF = float("inf")

dx = (1, 0, -1, 0, 0)
dy = (0, 1, 0, -1, 0)


def turn(y, x):
    for i in range(5):
        ny = y + dy[i]
        nx = x + dx[i]
        if checkRange(ny, nx):
            if board[ny][nx] == "O":
                board[ny][nx] = "#"
            elif board[ny][nx] == "#":
                board[ny][nx] = "O"


def checkRange(y, x):
    return 0 <= y < 10 and 0 <= x < 10


def turnButtom():
    count = 0
    targets = []

    for y in range(1, 10):
        for x in range(10):
            if board[y - 1][x] == "O":
                count += 1
                targets.append((y, x))
                turn(y, x)

    for x in range(10):
        if board[9][x] == "O":
            count = INF
            break

    for y, x in targets:
        turn(y, x)

    return count


def solve(currX, prevCount):
    if currX == 10:
        return prevCount + turnButtom()

    result = INF
    result = min(result, solve(currX + 1, prevCount))

    turn(0, currX)
    result = min(result, solve(currX + 1, prevCount + 1))
    turn(0, currX)

    return result


board = [list(input().strip()) for _ in range(10)]


answer = solve(0, 0)
if answer == INF:
    answer = -1

print(answer)