import sys

input = sys.stdin.readline


def count(target, number):
    result = 0
    num = number
    while num <= target:
        result += target // num
        num *= number
    return result


n, m = map(int, input().split())

twoCount = count(n, 2) - count(n - m, 2) - count(m, 2)
fiveCount = count(n, 5) - count(n - m, 5) - count(m, 5)

print(min(twoCount, fiveCount))