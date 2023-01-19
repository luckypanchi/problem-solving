import sys

input = sys.stdin.readline


def go(prev, idx, plus, minus, mul, div):
    if idx == n:
        results.append(prev)
        return

    if plus > 0:
        go(prev + numbers[idx], idx + 1, plus - 1, minus, mul, div)
    if minus > 0:
        go(prev - numbers[idx], idx + 1, plus, minus - 1, mul, div)
    if mul > 0:
        go(prev * numbers[idx], idx + 1, plus, minus, mul - 1, div)
    if div > 0:
        res = prev / numbers[idx]
        res = int(res)
        go(res, idx + 1, plus, minus, mul, div - 1)


n = int(input())
numbers = list(map(int, input().split()))
plus, minus, mul, div = map(int, input().split())

results = []

go(numbers[0], 1, plus, minus, mul, div)

print(max(results))
print(min(results))
