import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)

DIR = "RDLU"


def makeComb(prev):
    if len(prev) == 10:
        combinations.append(prev)
        return

    makeComb(prev + [(prev[-1] + 1) % 4])
    makeComb(prev + [(prev[-1] - 1) % 4])


def move(start, d):
    ny = start[0]
    nx = start[1]

    while board[ny + dy[d]][nx + dx[d]] != "#":
        ny += dy[d]
        nx += dx[d]

        if board[ny][nx] == "O":
            return (-1, -1)

    return (ny, nx)


combinations = []
for i in range(4):
    makeComb([i])


tc = int(input())
for _ in range(tc):
    n, m = map(int, input().split())
    board = [list(input().strip()) for _ in range(n)]

    initalPoints = []
    for i in range(n):
        for j in range(m):
            if board[i][j] == ".":
                initalPoints.append((i, j))

    answer = "XHAE"
    for comb in combinations:
        que = deque(initalPoints[:])
        finalRound = -1
        for round in range(10):
            dest = []
            while que:
                y, x = que.popleft()
                destY, destX = move((y, x), comb[round])
                if (destY, destX) != (-1, -1):
                    dest.append((destY, destX))

            que = deque(list(set(dest)))
            if len(que) == 0:
                finalRound = round + 1
                break

        if len(que) == 0:
            answer = ""
            for i in range(finalRound):
                answer += DIR[comb[i]]
            break

    print(answer)
