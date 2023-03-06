import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def bfs(start):
    que = deque(list(start))
    visited = [[False] * n for _ in range(n)]
    for y, x in start:
        visited[y][x] = True

    cnt = 0
    while que:
        length = len(que)
        for _ in range(length):
            y, x = que.popleft()
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if (
                    0 <= ny < n
                    and 0 <= nx < n
                    and not visited[ny][nx]
                    and board[ny][nx] != 1
                ):
                    visited[ny][nx] = True
                    que.append((ny, nx))
        cnt += 1

    for i in range(n):
        for j in range(n):
            if board[i][j] != 1 and visited[i][j] is False:
                return -1

    return cnt - 1


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
virus_start = []
for i in range(n):
    for j in range(n):
        if board[i][j] == 2:
            virus_start.append((i, j))
start_combs = list(combinations(virus_start, m))

results = []
failure = []
for comb in start_combs:
    result = bfs(comb)
    if result == -1:
        failure.append(result)
    else:
        results.append(result)

if len(results) == 0:
    print(-1)
else:
    print(min(results))