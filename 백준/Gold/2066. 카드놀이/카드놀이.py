import sys
import copy

input = sys.stdin.readline


def choosePair(array):
    results = []

    for idx1 in range(9):
        for idx2 in range(idx1 + 1, 9):
            if array[idx1] == 0 or array[idx2] == 0:
                continue

            if cards[idx1][array[idx1]] == cards[idx2][array[idx2]]:
                res = copy.deepcopy(array)
                res[idx1] -= 1
                res[idx2] -= 1

                results.append(res)

    return results


def solve(a, b, c, d, e, f, g, h, i):
    if dp[a][b][c][d][e][f][g][h][i] == 0:
        return

    choosedList = choosePair([a, b, c, d, e, f, g, h, i])

    if len(choosedList) == 0:
        return

    prod = (float)(dp[a][b][c][d][e][f][g][h][i]) / len(choosedList)

    for choosed in choosedList:
        dp[choosed[0]][choosed[1]][choosed[2]][choosed[3]][choosed[4]][choosed[5]][choosed[6]][choosed[7]][choosed[8]] += prod  # fmt: skip


cards = [[""] + list(map(lambda x: x[0], input().split())) for _ in range(9)]
dp = [[[[[[[[[0] * 5 for _ in range(5)] for _ in range(5)] for _ in range(5)] for _ in range(5)] for _ in range(5)] for _ in range(5)] for _ in range(5)] for _ in range(5)]  # fmt: skip

dp[4][4][4][4][4][4][4][4][4] = 1.0

for a in range(4, -1, -1):
    for b in range(4, -1, -1):
        for c in range(4, -1, -1):
            for d in range(4, -1, -1):
                for e in range(4, -1, -1):
                    for f in range(4, -1, -1):
                        for g in range(4, -1, -1):
                            for h in range(4, -1, -1):
                                for i in range(4, -1, -1):
                                    solve(a, b, c, d, e, f, g, h, i)

print(dp[0][0][0][0][0][0][0][0][0])