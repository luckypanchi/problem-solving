import sys
from collections import deque

input = sys.stdin.readline

dx = [1, 1, 0, -1, -1, -1, 0, 1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]


def main():
    def bfs(matrix, p):
        y, x = p
        matrix[y][x] = -1
        que = deque()
        que.append(p)
        while que:
            y, x = que.popleft()
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < m and 0 <= ny < n and matrix[ny][nx] == 1:
                    matrix[ny][nx] = -1
                    que.append((ny, nx))

    while True:
        m, n = map(int, input().split())

        if (m, n) == (0, 0):
            break

        matrix = [list(map(int, input().split())) for _ in range(n)]
        answer = 0

        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 1:
                    bfs(matrix, (i, j))
                    answer += 1

        print(answer)


main()
