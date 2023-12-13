import sys

input = sys.stdin.readline


h, w, x, y = map(int, input().split())
matrixA = [[0] * w for _ in range(h)]
matrixB = [list(map(int, input().split())) for _ in range(h + x)]

if y < w and x < h:
    for i in range(x):
        for j in range(w):
            matrixA[i][j] = matrixB[i][j]
    for i in range(x, h):
        for j in range(y):
            matrixA[i][j] = matrixB[i][j]
    for i in range(x, h):
        for j in range(y, w):
            matrixA[i][j] = matrixB[i][j] - matrixA[i - x][j - y]

else:
    for i in range(h):
        for j in range(w):
            matrixA[i][j] = matrixB[i][j]

for row in matrixA:
    print(*row)