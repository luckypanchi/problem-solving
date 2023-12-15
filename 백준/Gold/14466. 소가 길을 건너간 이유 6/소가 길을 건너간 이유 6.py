import sys
from collections import defaultdict, deque

input = sys.stdin.readline


dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def createKey(start, end):
    return f"({start}, {end})"


def bfs(cowIndex):
    y, x = cowList[cowIndex]

    que = deque()
    visited = [[False] * (n + 1) for _ in range(n + 1)]
    visitedCow = [False] * k

    que.append((y, x))
    visited[y][x] = True
    visitedCow[cowIndex] = True

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 1 <= nx < n + 1 and 1 <= ny < n + 1 and not visited[ny][nx]:
                if road[createKey((y, x), (ny, nx))] != 0 or road[createKey((ny, nx), (y, x))] != 0:
                    continue

                que.append((ny, nx))
                visited[ny][nx] = True

                if board[ny][nx] != -1:
                    visitedCow[board[ny][nx]] = True

    return visitedCow.count(False)


n, k, r = map(int, input().split())
board = [[-1] * (n + 1) for _ in range(n + 1)]
road = defaultdict(int)
for _ in range(r):
    a, b, c, d = map(int, input().split())
    road[createKey((a, b), (c, d))] += 1
    road[createKey((c, d), (a, b))] += 1

cowList = []
for i in range(k):
    a, b = map(int, input().split())
    board[a][b] = i
    cowList.append((a, b))

answer = 0
for cowIndex in range(k):
    answer += bfs(cowIndex)

print(answer // 2)