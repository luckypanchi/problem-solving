import sys

sys.setrecursionlimit(10**7)

INF = float("inf")


def solution(sequence):
    answer = 0
    n = len(sequence)

    dp = [[-INF] * 2 for _ in range(n)]

    def solve(curr, prevSign):
        if curr == n:
            return 0

        if dp[curr][prevSign] != -INF:
            return dp[curr][prevSign]

        result = -INF
        if prevSign == 0:  # -
            result = max(sequence[curr], solve(curr + 1, 1) + sequence[curr])
        elif prevSign == 1:  #  +
            result = max(-sequence[curr], solve(curr + 1, 0) - sequence[curr])

        dp[curr][prevSign] = result

        return dp[curr][prevSign]

    solve(0, 0)
    solve(0, 1)

    answer = -INF
    for i in range(n):
        for j in range(2):
            answer = max(answer, dp[i][j])

    return answer
