import sys

input = sys.stdin.readline

div = 1000000


numbers = [0] + list(map(int, input().strip()))
n = len(numbers)

dp = [0] * n
dp[0] = 1

flag = False

for i in range(1, n):
    if numbers[i] != 0:
        dp[i] += dp[i - 1] % div
    if numbers[i - 1] == 1 or (numbers[i - 1] == 2 and 0 <= numbers[i] < 7):
        dp[i] += dp[i - 2] % div
    if (numbers[i - 1] < 1 or 3 <= numbers[i - 1]) and numbers[i] == 0:
        flag = True
        break

if flag or n == 1:
    print(0)
else:
    print(dp[n - 1] % div)