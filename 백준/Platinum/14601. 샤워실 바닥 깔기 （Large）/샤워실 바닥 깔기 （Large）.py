import sys

input = sys.stdin.readline


def solve(startX, startY, midX, midY, length):
    global markNumber

    if length == 2:
        for y in range(startY, startY + 2):
            for x in range(startX, startX + 2):
                if (y, x) == (midY, midX):
                    continue
                board[y][x] = markNumber
        markNumber += 1
        return

    nextLength = length // 2
    nextX = startX + nextLength
    nextY = startY + nextLength

    if startY <= midY < startY + nextLength and startX <= midX < startX + nextLength:
        board[nextY - 1][nextX] = markNumber
        board[nextY][nextX - 1] = markNumber
        board[nextY][nextX] = markNumber
        markNumber += 1

        solve(startX, startY, midX, midY, nextLength)
        solve(nextX, startY, nextX, nextY - 1, nextLength)
        solve(startX, nextY, nextX - 1, nextY, nextLength)
        solve(nextX, nextY, nextX, nextY, nextLength)
    elif startY <= midY < startY + nextLength and startX + nextLength <= midX < startX + length:
        board[nextY - 1][nextX - 1] = markNumber
        board[nextY][nextX - 1] = markNumber
        board[nextY][nextX] = markNumber
        markNumber += 1

        solve(startX, startY, nextX - 1, nextY - 1, nextLength)
        solve(nextX, startY, midX, midY, nextLength)
        solve(startX, nextY, nextX - 1, nextY, nextLength)
        solve(nextX, nextY, nextX, nextY, nextLength)
    elif startY + nextLength <= midY < startY + length and startX <= midX < startX + nextLength:
        board[nextY - 1][nextX - 1] = markNumber
        board[nextY - 1][nextX] = markNumber
        board[nextY][nextX] = markNumber
        markNumber += 1

        solve(startX, startY, nextX - 1, nextY - 1, nextLength)
        solve(nextX, startY, nextX, nextY - 1, nextLength)
        solve(startX, nextY, midX, midY, nextLength)
        solve(nextX, nextY, nextX, nextY, nextLength)
    else:
        board[nextY - 1][nextX - 1] = markNumber
        board[nextY - 1][nextX] = markNumber
        board[nextY][nextX - 1] = markNumber
        markNumber += 1

        solve(startX, startY, nextX - 1, nextY - 1, nextLength)
        solve(nextX, startY, nextX, nextY - 1, nextLength)
        solve(startX, nextY, nextX - 1, nextY, nextLength)
        solve(nextX, nextY, midX, midY, nextLength)


k = int(input())
n = 2**k
targetX, targetY = map(int, input().split())
targetX -= 1
targetY = n - targetY

board = [[0] * n for _ in range(n)]
markNumber = 1

solve(0, 0, targetX, targetY, n)


board[targetY][targetX] = -1

if markNumber > 19001:
    print(-1)
else:
    for row in board:
        print(*row)