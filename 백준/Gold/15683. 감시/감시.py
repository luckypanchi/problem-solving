import sys

input = sys.stdin.readline

INF = float("INF")

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)

directions = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
    [[0, 1, 2, 3]],
]


def solve(curr, prevCount):
    global answer
    if curr == len(cameras):
        answer = min(answer, totalCount - prevCount)
        return

    cameraType, y, x = cameras[curr]

    for dirList in directions[cameraType]:
        marked = []
        count = 0
        for d in dirList:
            ny = y
            nx = x
            while (
                0 <= ny + dy[d] < n and 0 <= nx + dx[d] < m and board[ny + dy[d]][nx + dx[d]] != 6
            ):
                ny += dy[d]
                nx += dx[d]
                if board[ny][nx] == 0:
                    board[ny][nx] = "#"
                    marked.append((ny, nx))
                    count += 1

        solve(curr + 1, prevCount + count)

        for ny, nx in marked:
            board[ny][nx] = 0


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

cameras = []
totalCount = 0
for i in range(n):
    for j in range(m):
        if 1 <= board[i][j] < 6:
            cameras.append((board[i][j], i, j))
        elif board[i][j] == 0:
            totalCount += 1

answer = INF

solve(0, 0)

print(answer)