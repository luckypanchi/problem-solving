import sys
from collections import deque

input = sys.stdin.readline

# 홀수
dx1 = (1, 1, 0, -1, 0, 1)
dy1 = (0, 1, 1, 0, -1, -1)

# 짝수
dx2 = (1, 0, -1, -1, -1, 0)
dy2 = (0, 1, 1, 0, -1, -1)


w, h = map(int, input().split())

n, m = h + 2, w + 2

board = [[0] * m] + [[0] + list(map(int, input().split())) + [0] for _ in range(h)] + [[0] * m]


que = deque()
que.append((0, 0))

board[0][0] = -1

while que:
    y, x = que.popleft()

    if y % 2 != 0:
        dy, dx = dy1, dx1
    else:
        dy, dx = dy2, dx2

    for i in range(6):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < m and board[ny][nx] == 0:
            board[ny][nx] = -1
            que.append((ny, nx))


answer = 0

for y in range(n):
    for x in range(m):
        if board[y][x] == 1:
            if y % 2 != 0:
                dy, dx = dy1, dx1
            else:
                dy, dx = dy2, dx2

            for i in range(6):
                ny = y + dy[i]
                nx = x + dx[i]
                if board[ny][nx] == -1:
                    answer += 1

print(answer)