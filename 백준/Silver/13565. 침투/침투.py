import sys
from collections import deque

input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().strip())) for _ in range(n)]

    def bfs(matrix, y, x):
        que = deque()
        que.append((y, x))
        matrix[y][x] = -1
        while que:
            y, x = que.popleft()

            if y == len(matrix) - 1:
                return 1

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < m and 0 <= ny < n and matrix[ny][nx] == 0:
                    matrix[ny][nx] = -1
                    que.append((ny, nx))

        return 0

    for i in range(m):
        if matrix[0][i] == 0:
            result = bfs(matrix, 0, i)
            if result:
                print("YES")
                sys.exit(0)

    print("NO")


main()
