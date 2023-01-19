import sys

input = sys.stdin.readline


n = int(input())

for c in range(n, 0, -1):
    print(" " * (n - c) + "*" * c)
