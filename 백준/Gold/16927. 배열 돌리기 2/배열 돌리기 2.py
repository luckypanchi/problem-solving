import sys
from collections import deque

input = sys.stdin.readline


def rotate():
    y, x = 0, 0
    r = n - 1
    c = m - 1
    while 1 <= r and 1 <= c:
        loop = total % (2 * (r + c))
        for _ in range(loop):
            que = deque()
            for i in range(r):
                que.append(matrix[y + i][x])
            for i in range(c):
                que.append(matrix[y + r][x + i])
            for i in range(r):
                que.append(matrix[y + r - i][x + c])
            for i in range(c):
                que.append(matrix[y][x + c - i])

            que.rotate()

            for i in range(r):
                matrix[y + i][x] = que.popleft()
            for i in range(c):
                matrix[y + r][x + i] = que.popleft()
            for i in range(r):
                matrix[y + r - i][x + c] = que.popleft()
            for i in range(c):
                matrix[y][x + c - i] = que.popleft()

        y += 1
        x += 1
        r -= 2
        c -= 2


n, m, total = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]


rotate()

for row in matrix:
    print(*row)
