import sys
import math

sys.setrecursionlimit(10**6)

input = sys.stdin.readline


def solve(number):
    if number <= 0:
        return 0

    n = int(math.log2(number))
    m = 2**n
    if m == number:
        return n * m // 2 + 1

    diff = number - m
    return solve(m) + diff + solve(diff)


a, b = map(int, input().split())
print(solve(b) - solve(a - 1))