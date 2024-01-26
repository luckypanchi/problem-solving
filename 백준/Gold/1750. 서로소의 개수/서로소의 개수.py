import sys
from math import gcd

input = sys.stdin.readline

MOD = 10000003


n = int(input())
numbers = [int(input()) for _ in range(n)]
_max = max(numbers)

dp = [0] * (_max + 1)

for i in range(n):
    for j in range(1, _max + 1):
        if dp[j] > 0:
            _gcd = gcd(numbers[i], j)
            dp[_gcd] = (dp[_gcd] + dp[j]) % MOD

    dp[numbers[i]] = (dp[numbers[i]] + 1) % MOD


print(dp[1])