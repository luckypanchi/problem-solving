import sys

input = sys.stdin.readline


n = int(input())
k = int(input())

dp = [0] * 41
fibo = [0] * 41
fiboSum = [0] * 41

fibo[0] = 1
fibo[1] = 1
fiboSum[0] = 1
fiboSum[1] = 2

for i in range(2, n + 1):
    fibo[i] = fibo[i - 1] + fibo[i - 2]
    fiboSum[i] = fiboSum[i - 1] + fibo[i]

dp[0] = 1
dp[1] = 1
dp[2] = 2

for i in range(3, n + 1):
    dp[i] = dp[i - 1] + dp[i - 2] + fiboSum[i - 3] + fiboSum[i - 2]

answer = dp[k] * fibo[n - k] + fibo[k - 1] * dp[n - k + 1] - fibo[k - 1] * fibo[n - k]

print(answer)