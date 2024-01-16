import sys

input = sys.stdin.readline

MOD = 1000000


def solve(left, right):
    if left + right == 0:
        return 1

    if dp[left][right] != -1:
        return dp[left][right]

    result = 0
    for i in range(right):
        result += solve(right - i - 1, left + i)
        result %= MOD

    dp[left][right] = result
    return dp[left][right]


n = int(input())

if n == 1:
    print(1)
    sys.exit()

dp = [[-1] * n for _ in range(n)]

answer = 0
for i in range(n):
    answer += solve(i, n - i - 1)
    answer += solve(n - i - 1, i)
    answer %= MOD

print(answer)