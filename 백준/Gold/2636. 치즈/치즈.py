import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


def bfs():
    que = deque()
    visited = [[False] * m for _ in range(n)]

    que.append((0, 0))
    visited[0][0] = True

    cnt = 0

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx]:
                visited[ny][nx] = True
                if board[ny][nx] == 0:
                    que.append((ny, nx))
                elif board[ny][nx] == 1:
                    board[ny][nx] = 0
                    cnt += 1

    return cnt


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

totalCnt = 0
for i in range(n):
    totalCnt += sum(board[i])

t = 0
cnt = -1
while totalCnt:
    t += 1
    cnt = bfs()
    totalCnt -= cnt

print(t)
print(cnt)