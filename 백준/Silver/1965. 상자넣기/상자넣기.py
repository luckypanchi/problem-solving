import sys

input = sys.stdin.readline


n = int(input())
numbers = list(map(int, input().split()))

dp = [1] * n

for i in range(1, n):
    for prev in range(i):
        if numbers[prev] < numbers[i]:
            dp[i] = max(dp[i], dp[prev] + 1)

print(max(dp))