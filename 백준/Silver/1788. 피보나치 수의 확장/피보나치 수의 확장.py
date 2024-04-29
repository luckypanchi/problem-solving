import sys

input = sys.stdin.readline

MOD = 1000000000


n = int(input())


dp = [0] * (abs(n) + 2)
dp[0] = 0
dp[1] = 1

for i in range(2, abs(n) + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD

if n == 0:
    print(0)
elif n > 0 or abs(n) % 2 != 0:
    print(1)
else:
    print(-1)

print(dp[abs(n)])