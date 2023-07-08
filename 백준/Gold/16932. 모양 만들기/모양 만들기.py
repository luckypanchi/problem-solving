import sys
from collections import defaultdict, deque


input = sys.stdin.readline

INF = float("inf")

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def get_sizes():
    idx = 0

    for i in range(n):
        for j in range(m):
            if board[i][j] == 1 and idx_board[i][j] == 0:
                idx += 1

                que = deque()
                que.append((i, j))

                s = 1
                idx_board[i][j] = idx

                while que:
                    y, x = que.popleft()

                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if (
                            0 <= ny < n
                            and 0 <= nx < m
                            and idx_board[ny][nx] == 0
                            and board[ny][nx] == 1
                        ):
                            que.append((ny, nx))
                            s += 1
                            idx_board[ny][nx] = idx

                sizes[idx] = s


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

idx_board = [[0] * m for _ in range(n)]
sizes = defaultdict(int)

get_sizes()


answer = -INF

for y in range(n):
    for x in range(m):
        if board[y][x] == 0:
            visited = set()

            s = 1
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < n and 0 <= nx < m and board[ny][nx] == 1:
                    idx = idx_board[ny][nx]
                    if idx not in visited:
                        s += sizes[idx]
                        visited.add(idx)

            answer = max(answer, s)


print(answer)