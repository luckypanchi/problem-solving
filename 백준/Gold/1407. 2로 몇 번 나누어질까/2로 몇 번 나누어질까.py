import sys

input = sys.stdin.readline


def f(target):
    result = target
    num = 1
    while 2**num <= target:
        result += 2**num * (target // 2**num) - 2 ** (num - 1) * (target // 2**num)
        num += 1
    return result


a, b = map(int, input().split())

print(f(b) - f(a - 1))