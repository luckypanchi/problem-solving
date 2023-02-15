import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


def melt():
    que_length = len(water_que)
    for _ in range(que_length):
        y, x = water_que.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (
                0 <= ny < r
                and 0 <= nx < c
                and board[ny][nx] == "X"
                and not water_visited[ny][nx]
            ):
                board[ny][nx] = "."
                water_visited[ny][nx] = True
                water_que.append((ny, nx))


def move_swan():
    global swan_que
    que = swan_que
    swan_que = deque()
    while que:
        y, x = que.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < r and 0 <= nx < c and not swan_visited[ny][nx]:
                swan_visited[ny][nx] = True
                if (ny, nx) == (ey, ex):
                    return True
                elif board[ny][nx] == ".":
                    que.append((ny, nx))
                elif board[ny][nx] == "X":
                    swan_que.append((ny, nx))
    return False


r, c = map(int, input().split())
board = []
water_visited = [[False] * c for _ in range(r)]
swan_visited = [[False] * c for _ in range(r)]
swans = []
water_que = deque()
swan_que = deque()

for i in range(r):
    row = list(input().strip())
    for j in range(c):
        if row[j] == "L":
            water_visited[i][j] = True
            water_que.append((i, j))
            swans.append((i, j))
        if row[j] == ".":
            water_visited[i][j] = True
            water_que.append((i, j))
    board.append(row)

cnt = 0
sy, sx = swans[0]
ey, ex = swans[1]

swan_que.append((sy, sx))
swan_visited[sy][sx] = True

while True:
    if move_swan():
        break
    melt()
    cnt += 1


print(cnt)