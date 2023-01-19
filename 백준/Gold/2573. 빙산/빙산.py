import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    def bfs(p, visited):
        y, x = p
        visited[y][x] = -1
        que = deque()
        que.append((y, x))
        cnt = 1
        while que:
            y, x = que.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if (
                    0 <= nx < m
                    and 0 <= ny < n
                    and visited[ny][nx] == 0
                    and matrix[ny][nx] != 0
                ):
                    visited[ny][nx] = -1
                    cnt += 1
                    que.append((ny, nx))
        return cnt

    def check(total):
        visited = [[0] * m for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if matrix[i][j] != 0 and visited[i][j] == 0:
                    cnt = bfs((i, j), visited)
                    if cnt < total:
                        return False
                    else:
                        return True

    year = 0

    while True:
        year += 1
        temp = [[0] * m for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if matrix[i][j] != 0:
                    for k in range(4):
                        ni = i + dy[k]
                        nj = j + dx[k]
                        if matrix[ni][nj] == 0:
                            temp[i][j] += 1

        zero_cnt = 0

        for i in range(n):
            for j in range(m):
                matrix[i][j] = max(matrix[i][j] - temp[i][j], 0)
                if matrix[i][j] == 0:
                    zero_cnt += 1

        if n * m == zero_cnt:
            print(0)
            return

        if not check(n * m - zero_cnt):
            print(year)
            return


main()
