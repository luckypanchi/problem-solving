import sys
from collections import defaultdict, deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


r, c = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]

sheep = defaultdict(int)
wolf = defaultdict(int)

visited = [[False] * c for _ in range(r)]
mark = 0


def bfs(y, x, number):
    que = deque()
    que.append((y, x))

    visited[y][x] = True

    while que:
        y, x = que.popleft()

        if board[y][x] == "o":
            sheep[number] += 1
        elif board[y][x] == "v":
            wolf[number] += 1

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < r and 0 <= nx < c and board[ny][nx] != "#" and not visited[ny][nx]:
                visited[ny][nx] = True
                que.append((ny, nx))


for y in range(r):
    for x in range(c):
        if not board[y][x] != "#" and not visited[y][x]:
            mark += 1
            bfs(y, x, mark)


total_sheep = 0
total_wolf = 0

for idx in range(1, mark + 1):
    if sheep[idx] <= wolf[idx]:
        total_wolf += wolf[idx]
    else:
        total_sheep += sheep[idx]

print(total_sheep, total_wolf)