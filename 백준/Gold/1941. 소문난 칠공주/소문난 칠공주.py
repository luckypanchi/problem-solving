import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)

board = [list(input().strip()) for _ in range(5)]

combs = combinations(range(25), 7)
answer = 0

for comb in combs:
    visited1 = [[False] * 5 for _ in range(5)]
    for idx in comb:
        y = idx // 5
        x = idx % 5
        visited1[y][x] = True

    cnt = 0
    flag = [0]
    visited2 = [[False] * 5 for _ in range(5)]
    for i in range(5):
        for j in range(5):
            if visited1[i][j] and not visited2[i][j]:
                cnt += 1
                flag.append(0)

                dasom = 0
                visited2[i][j] = True
                que = deque()
                que.append((i, j))

                while que:
                    y, x = que.popleft()

                    if board[y][x] == "S":
                        dasom += 1

                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if 0 <= ny < 5 and 0 <= nx < 5 and visited1[ny][nx] and not visited2[ny][nx]:
                            visited2[ny][nx] = True
                            que.append((ny, nx))

                flag[cnt] = dasom

    if cnt == 1 and 4 <= flag[1]:
        answer += 1


print(answer)