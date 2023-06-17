import sys

input = sys.stdin.readline


flag = [False] * 31
numbers = [int(input()) for _ in range(28)]

for n in numbers:
    flag[n] = True

for n in range(1, 31):
    if not flag[n]:
        print(n)