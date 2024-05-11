import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr, start):
    if curr == k:
        mat = 0
        for i in range(n):
            if isSelected[i]:
                for j in range(i + 1, n):
                    if isSelected[j]:
                        mat += board[i][j]

        return mat

    result = -INF
    for i in range(start, n):
        isSelected[i] = True
        result = max(result, solve(curr + 1, i + 1))
        isSelected[i] = False

    return result


n, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

isSelected = [False] * n

print(solve(0, 0))