import sys

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    n = int(input())
    prices = list(map(int, input().split()))
    answer = 0
    max_price = 0
    for i in range(n - 1, -1, -1):
        if max_price < prices[i]:
            max_price = prices[i]
        else:
            answer += max_price - prices[i]
    print(answer)
