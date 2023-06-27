import sys

input = sys.stdin.readline


def euclidean(a, b):
    while b != 0:
        [a, b] = [b, a % b]
    return a


a, b = map(int, input().split())

gcd = euclidean(a, b)

print("1" * gcd)