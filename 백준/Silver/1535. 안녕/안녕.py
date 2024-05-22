import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr, hp):
    if hp <= 0:
        return -INF

    if curr == n:
        return 0

    if dp[curr][hp] != -1:
        return dp[curr][hp]

    dp[curr][hp] = max(solve(curr + 1, hp), solve(curr + 1, hp - stress[curr]) + joy[curr])

    return dp[curr][hp]


n = int(input())
stress = list(map(int, input().split()))
joy = list(map(int, input().split()))

dp = [[-1] * 101 for _ in range(21)]

print(solve(0, 100))
