import sys

input = sys.stdin.readline


def solve(start, end):
    if dp[start][end] != -1:
        return dp[start][end]

    if end <= start:
        return 1

    dp[start][end] = 0
    if numbers[start] == numbers[end] and solve(start + 1, end - 1) == 1:
        dp[start][end] = 1

    return dp[start][end]


n = int(input())
numbers = list(map(int, input().split()))
dp = [[-1] * n for _ in range(n)]
for i in range(n):
    dp[i][i] = 1

m = int(input())
for _ in range(m):
    s, e = map(int, input().split())
    print(solve(s - 1, e - 1))
