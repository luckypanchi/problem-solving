import sys

input = sys.stdin.readline

MOD = 1000000007


n = int(input())
matrix = [[1, 1], [1, 0]]


def multiply(m1, m2):
    res = [[0] * 2 for _ in range(2)]

    for i in range(2):
        for j in range(2):
            for k in range(2):
                res[i][j] += m1[i][k] * m2[k][j]
                res[i][j] = res[i][j] % MOD

    return res


def pow(a, b):
    if b == 1:
        return a
    else:
        tmp = pow(a, b // 2)
        res = multiply(tmp, tmp)

        if b % 2 == 0:
            return res
        else:
            return multiply(res, a)


result = pow(matrix, n)
answer = result[0][1] % MOD

print(answer)