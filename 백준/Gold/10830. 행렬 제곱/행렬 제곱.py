import sys

input = sys.stdin.readline


def pow(matrix, n):
    if n == 1:
        return matrix

    tmp_result = pow(matrix, n // 2)
    result = multiply(tmp_result, tmp_result)
    if n % 2 == 1:
        result = multiply(result, matrix)

    return result


def multiply(a, b):
    result = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            for k in range(n):
                result[i][j] += a[i][k] * b[k][j]
            result[i][j] = result[i][j] % 1000

    return result


n, b = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    for j in range(n):
        matrix[i][j] = matrix[i][j] % 1000

answer = pow(matrix, b)

for row in answer:
    print(*row)