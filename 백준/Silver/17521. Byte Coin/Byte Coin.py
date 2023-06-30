import sys

input = sys.stdin.readline


n, cash = map(int, input().split())

prices = [int(input()) for _ in range(n)]

coins = 0

for i in range(n - 1):
    if prices[i] < prices[i + 1]:
        if 0 < cash // prices[i]:
            coins = cash // prices[i]
            cash -= coins * prices[i]
    elif prices[i - 1] < prices[i]:
        cash += coins * prices[i]
        coins = 0

if 0 < coins:
    cash += coins * prices[n - 1]

print(cash)