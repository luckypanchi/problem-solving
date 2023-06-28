import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


n, m, k = map(int, input().split())
board = [[0] * m for _ in range(n)]
check = [[0] * m for _ in range(n)]

for _ in range(k):
    a, b = map(int, input().split())
    board[a - 1][b - 1] = 1


def bfs(y, x, num):
    que = deque()
    que.append((y, x))
    check[y][x] = num

    cnt = 1

    while que:
        y, x = que.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and check[ny][nx] == 0 and board[ny][nx] == 1:
                check[ny][nx] = num
                que.append((ny, nx))
                cnt += 1

    return cnt


num = 1
answer = 0

for y in range(n):
    for x in range(m):
        if board[y][x] == 1 and check[y][x] == 0:
            answer = max(answer, bfs(y, x, num))
            num += 1


print(answer)