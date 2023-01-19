import sys

input = sys.stdin.readline


numbers = sorted(list(map(int, input().split())))
print(numbers[-2])
