import sys

input = sys.stdin.readline

tc = int(input())

for _ in range(tc):
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(2)]

    if n == 1:
        print(max(matrix[0][0], matrix[1][0]))

    else:
        matrix[0][1] += matrix[1][0]
        matrix[1][1] += matrix[0][0]

        for j in range(2, n):
            matrix[0][j] += max(matrix[1][j - 1], matrix[1][j - 2])
            matrix[1][j] += max(matrix[0][j - 1], matrix[0][j - 2])

        print(max(matrix[0][n - 1], matrix[1][n - 1]))
