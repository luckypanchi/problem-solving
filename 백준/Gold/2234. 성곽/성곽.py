import sys
from collections import deque, defaultdict

input = sys.stdin.readline

dx = (-1, 0, 1, 0)
dy = (0, -1, 0, 1)


m, n = map(int, input().split())
wall_info = [list(map(int, input().split())) for _ in range(n)]

board = [[0] * m for _ in range(n)]
room_number = 1
room_info = defaultdict(int)


def bfs(y, x):
    que = deque()
    que.append((y, x))

    board[y][x] = room_number
    cnt = 1

    while que:
        y, x = que.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (
                0 <= ny < n
                and 0 <= nx < m
                and board[ny][nx] == 0
                and not (wall_info[y][x] & (1 << i))
            ):
                cnt += 1
                board[ny][nx] = room_number
                que.append((ny, nx))

    return cnt


for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            room_info[room_number] = bfs(i, j)
            room_number += 1

broken = 0

for y in range(n):
    for x in range(m):
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and board[y][x] != board[ny][nx]:
                broken = max(broken, room_info[board[y][x]] + room_info[board[ny][nx]])


print(len(room_info))
print(max(room_info.values()))
print(broken)
