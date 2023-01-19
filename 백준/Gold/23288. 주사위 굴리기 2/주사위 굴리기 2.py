import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def roll(d):
    global dice

    if d == 0:
        dice[0], dice[4], dice[2], dice[5] = dice[5], dice[0], dice[4], dice[2]
    if d == 1:
        dice[0], dice[3], dice[2], dice[1] = dice[1], dice[0], dice[3], dice[2]
    if d == 2:
        dice[0], dice[5], dice[2], dice[4] = dice[4], dice[0], dice[5], dice[2]
    if d == 3:
        dice[0], dice[1], dice[2], dice[3] = dice[3], dice[0], dice[1], dice[2]


def move():
    global y, x, direction, row_head, ver_head

    if not (0 <= y + dy[direction] < n and 0 <= x + dx[direction] < m):
        direction = (direction + 2) % 4
    y += dy[direction]
    x += dx[direction]
    roll(direction)


def get_point(y, x):
    point = matrix[y][x]
    cnt = 1
    visited = [[0] * m for _ in range(n)]
    visited[y][x] = 1
    que = deque()
    que.append((y, x))
    while que:
        y, x = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (
                0 <= nx < m
                and 0 <= ny < n
                and visited[ny][nx] == 0
                and matrix[ny][nx] == point
            ):
                cnt += 1
                visited[ny][nx] = 1
                que.append((ny, nx))
    return cnt * point


def direct(y, x):
    global direction

    if dice[2] > matrix[y][x]:
        direction = (direction + 1) % 4
    elif dice[2] < matrix[y][x]:
        direction = (direction - 1) % 4


n, m, k = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

dice = [1, 2, 6, 5, 3, 4]

y, x = 0, 0
direction = 0
answer = 0

for _ in range(k):
    move()
    answer += get_point(y, x)
    direct(y, x)

print(answer)
