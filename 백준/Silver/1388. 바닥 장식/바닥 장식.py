import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def checkRange(y, x):
    return 0 <= y < n and 0 <= x < m


def move(startY, startX, woodType):
    if woodType == "-":
        directions = [0, 2]
    elif woodType == "|":
        directions = [1, 3]

    que = deque()
    que.append((startY, startX))

    while que:
        y, x = que.popleft()

        for i in directions:
            ny = y + dy[i]
            nx = x + dx[i]
            if checkRange(ny, nx) and not visited[ny][nx] and board[ny][nx] == woodType:
                visited[ny][nx] = True
                que.append((ny, nx))


n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

visited = [[False] * m for _ in range(n)]
answer = 0

for i in range(n):
    for j in range(m):
        if not visited[i][j]:
            answer += 1
            visited[i][j] = True
            move(i, j, board[i][j])

print(answer)