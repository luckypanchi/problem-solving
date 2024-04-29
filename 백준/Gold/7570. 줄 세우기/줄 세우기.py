import sys

input = sys.stdin.readline


n = int(input())
children = list(map(int, input().split()))

dp = [0] * (n + 1)

for c in children:
    dp[c] = dp[c - 1] + 1

print(n - max(dp))