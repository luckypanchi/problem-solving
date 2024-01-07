import sys

input = sys.stdin.readline


def dfs(prev, start):
    if start == n:
        return 0

    if dp[start] != -1:
        return dp[start]

    for end in range(start, n):
        score = max(scores[start : end + 1]) - min(scores[start : end + 1])
        nextScore = dfs(prev + score, end + 1)
        dp[start] = max(dp[start], nextScore + score)

    return dp[start]


n = int(input())
scores = list(map(int, input().split()))

dp = [-1] * (n + 1)


dfs(0, 0)

print(dp[0])