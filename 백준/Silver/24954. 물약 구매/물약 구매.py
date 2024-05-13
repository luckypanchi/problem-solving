import sys
from collections import defaultdict

input = sys.stdin.readline

INF = float("inf")


def solve(curr, priceList, prevPrice):
    if curr == n:
        return prevPrice

    result = INF

    for i in range(n):
        if not isSelected[i]:
            copiedPriceList = priceList[:]
            isSelected[i] = True

            for posion, p in discounts[i]:
                copiedPriceList[posion - 1] = max(1, copiedPriceList[posion - 1] - p)

            result = min(result, solve(curr + 1, copiedPriceList, prevPrice + copiedPriceList[i]))
            isSelected[i] = False

    return result


n = int(input())
prices = list(map(int, input().split()))
discounts = defaultdict(list)
for i in range(n):
    p = int(input())
    for _ in range(p):
        discounts[i].append(tuple(map(int, input().split())))


isSelected = [False] * n

print(solve(0, prices, 0))