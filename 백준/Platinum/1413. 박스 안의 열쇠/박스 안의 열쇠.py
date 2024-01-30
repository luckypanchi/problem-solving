import sys
import math

input = sys.stdin.readline


n, m = map(int, input().split())
dp = [[0] * (m + 1) for _ in range(n + 1)]

dp[1][1] = 1
for box in range(2, n + 1):
    for bomb in range(1, min(box + 1, m + 1)):
        dp[box][bomb] = dp[box - 1][bomb - 1] + (box - 1) * dp[box - 1][bomb]

a = 0
for i in range(1, m + 1):
    a += dp[n][i]

b = 1
for i in range(1, n + 1):
    b *= i

gcd = math.gcd(a, b)
print(f"{a // gcd}/{b // gcd}")