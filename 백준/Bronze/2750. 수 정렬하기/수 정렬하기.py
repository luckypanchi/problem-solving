import sys

input = sys.stdin.readline

n = int(input())
numbers = sorted([int(input()) for _ in range(n)])

for num in numbers:
    print(num)
