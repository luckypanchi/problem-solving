import sys

input = sys.stdin.readline


def solve(startY, startX, trashCount):
    flag = False
    for y in range(startY, n):
        for x in range(startX, m):
            if board[y][x] == 1:
                board[y][x] = 0
                trashCount = solve(y, x, trashCount + 1)
                flag = True
                break
        if flag:
            break

    return trashCount


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

answer = 0
while True:
    trashCount = solve(0, 0, 0)
    if trashCount == 0:
        break

    answer += 1


print(answer)
