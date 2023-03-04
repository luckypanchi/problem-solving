import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


m, n = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

que = deque()

flag = True
for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            flag = False
        if board[i][j] == 1:
            que.append((i, j))

if flag:
    print(0)
    sys.exit()

answer = -1
while que:
    length = len(que)
    for _ in range(length):
        y, x = que.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and board[ny][nx] == 0:
                board[ny][nx] = 1
                que.append((ny, nx))
    answer += 1

for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            print(-1)
            sys.exit()

print(answer)