import sys
from copy import deepcopy
from itertools import permutations

input = sys.stdin.readline


def get_sum(arr):
    t = 9999
    for idx in range(1, len(arr)):
        t = min(t, sum(arr[idx]))
    return t


def rotate(pivot, matrix):
    r, c, s = pivot
    arr = deepcopy(matrix)

    for i in range(s, 0, -1):
        tmp1 = arr[r - i][c + i]
        for idx in range(c + i, c - i, -1):
            arr[r - i][idx] = arr[r - i][idx - 1]
        tmp2 = arr[r + i][c + i]
        for idx in range(r + i, r - i, -1):
            arr[idx][c + i] = arr[idx - 1][c + i]
        arr[r - i + 1][c + i] = tmp1
        tmp1 = arr[r + i][c - i]
        for idx in range(c - i, c + i):
            arr[r + i][idx] = arr[r + i][idx + 1]
        arr[r + i][c + i - 1] = tmp2
        for idx in range(r - i, r + i):
            arr[idx][c - i] = arr[idx + 1][c - i]
        arr[r + i - 1][c - i] = tmp1

    return arr


def main():
    n, m, k = map(int, input().split())
    matrix = [[0] * m]
    for _ in range(n):
        matrix.append([0] + list(map(int, input().split())))
    operators = [list(map(int, input().split())) for _ in range(k)]

    answer = 9999

    for ops in list(permutations(operators)):
        arr = deepcopy(matrix)
        for op in ops:
            arr = rotate(op, arr)
        answer = min(answer, get_sum(arr))

    print(answer)


main()
