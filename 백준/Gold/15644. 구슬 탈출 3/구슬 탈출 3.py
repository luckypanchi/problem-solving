import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)

directions = ["R", "D", "L", "U"]


def move(currY, currX, d):
    moveCount = 0
    while board[currY + dy[d]][currX + dx[d]] != "#" and board[currY][currX] != "O":
        currY += dy[d]
        currX += dx[d]
        moveCount += 1
    return currY, currX, moveCount


def bfs():
    visited = [[[[False] * m for _ in range(n)] for _ in range(m)] for _ in range(n)]
    visited[red[0]][red[1]][blue[0]][blue[1]] = True

    que = deque()
    que.append((red[0], red[1], blue[0], blue[1], ""))

    while que:
        redY, redX, blueY, blueX, history = que.popleft()

        if len(history) >= 10:
            continue

        for i in range(4):
            nRedY, nRedX, redMoveCount = move(redY, redX, i)
            nBlueY, nBlueX, blueMoveCount = move(blueY, blueX, i)

            if board[nBlueY][nBlueX] == "O":
                continue

            if board[nRedY][nRedX] == "O":
                return history + directions[i]

            if (nRedY, nRedX) == (nBlueY, nBlueX):
                if blueMoveCount < redMoveCount:
                    nRedY -= dy[i]
                    nRedX -= dx[i]
                else:
                    nBlueY -= dy[i]
                    nBlueX -= dx[i]

            if not visited[nRedY][nRedX][nBlueY][nBlueX]:
                visited[nRedY][nRedX][nBlueY][nBlueX] = True
                que.append((nRedY, nRedX, nBlueY, nBlueX, history + directions[i]))

    return ""


n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

red = tuple()
blue = tuple()

for i in range(n):
    for j in range(m):
        if board[i][j] == "R":
            red = (i, j)
        elif board[i][j] == "B":
            blue = (i, j)

answer = bfs()

if len(answer) == 0:
    print(-1)
else:
    print(len(answer))
    print(answer)