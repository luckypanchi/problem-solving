import sys

input = sys.stdin.readline


MOD = 1000000007


n = int(input())

matrix = [
    [0, 1, 1, 0, 0, 0, 0, 0],
    [1, 0, 1, 1, 0, 0, 0, 0],
    [1, 1, 0, 1, 1, 0, 0, 0],
    [0, 1, 1, 0, 1, 1, 0, 0],
    [0, 0, 1, 1, 0, 1, 0, 1],
    [0, 0, 0, 1, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 1, 0, 1],
    [0, 0, 0, 0, 1, 0, 1, 0],
]


def multi(m1, m2):
    current = [[0] * 8 for _ in range(8)]

    for i in range(8):
        for j in range(8):
            for k in range(8):
                current[i][j] += m1[i][k] * m2[k][j]
                current[i][j] %= MOD

    return current


def pow(matrix, n):
    if n == 1:
        return matrix

    half = pow(matrix, n // 2)
    res = multi(half, half)
    if n % 2 == 1:
        res = multi(res, matrix)

    return res


answer = pow(matrix, n)

print(answer[0][0])