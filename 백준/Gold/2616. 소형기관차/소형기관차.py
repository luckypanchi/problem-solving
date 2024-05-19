import sys

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


INF = float("inf")


def solve(curr, count):
    if count == 3 or curr == n:
        return 0

    if dp[curr][count] != -1:
        return dp[curr][count]

    result = -INF
    result = max(result, solve(curr + 1, count))

    if curr + trainCount < n + 1:
        result = max(
            result, solve(curr + trainCount, count + 1) + trains[curr + trainCount] - trains[curr]
        )

    dp[curr][count] = result

    return dp[curr][count]


n = int(input())
trains = [0] + list(map(int, input().split()))
for i in range(1, n + 1):
    trains[i] += trains[i - 1]
trainCount = int(input())
dp = [[-1] * 3 for _ in range(n)]

print(solve(0, 0))