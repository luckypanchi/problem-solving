import sys
from copy import deepcopy
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    n, q = map(int, input().split())
    n = 2**n
    matrix = [list(map(int, input().split())) for _ in range(n)]
    steps = list(map(int, input().split()))

    for step in steps:
        s = 2**step
        for i in range(0, n, s):
            for j in range(0, n, s):
                tmp = [matrix[k][j : j + s] for k in range(i, i + s)]
                tmp = [arr[::-1] for arr in zip(*tmp)]
                for r in range(s):
                    for c in range(s):
                        matrix[i + r][j + c] = tmp[r][c]

        check = deepcopy(matrix)
        for y in range(n):
            for x in range(n):
                if matrix[y][x] != 0:
                    cnt = 0
                    for i in range(4):
                        ny = y + dy[i]
                        nx = x + dx[i]
                        if 0 <= nx < n and 0 <= ny < n and check[ny][nx] != 0:
                            cnt += 1
                    if cnt < 3:
                        matrix[y][x] -= 1

    visited = [[0] * n for _ in range(n)]
    answer1, answer2 = 0, 0
    for i in range(n):
        for j in range(n):
            if matrix[i][j] != 0 and visited[i][j] == 0:
                que = deque()
                que.append((i, j))
                visited[i][j] = 1
                cnt = 1
                while que:
                    y, x = que.popleft()
                    answer1 += matrix[y][x]
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if (
                            0 <= nx < n
                            and 0 <= ny < n
                            and matrix[ny][nx] != 0
                            and visited[ny][nx] == 0
                        ):
                            visited[ny][nx] = 1
                            cnt += 1
                            que.append((ny, nx))
                answer2 = max(answer2, cnt)

    print(answer1)
    print(answer2)


main()
