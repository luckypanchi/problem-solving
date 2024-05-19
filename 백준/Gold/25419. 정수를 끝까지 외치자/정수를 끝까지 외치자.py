import sys

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def solve(curr):
    if n < curr:
        return 0

    if dp[curr] != -1:
        return dp[curr]

    dp[curr] = 1
    for nextNumber in range(curr + 1, curr + k + 1):
        if solve(nextNumber) == 1:
            dp[curr] = 0
            break

    return dp[curr]


n, k = map(int, input().split())
blacklist = list(map(int, input().split()))
dp = [-1] * (n + 1)
for black in blacklist:
    dp[black] = 0


solve(0)

answer = 0
for i in range(1, k + 1):
    if solve(i) == 1:
        answer = 1
        break

print(answer)