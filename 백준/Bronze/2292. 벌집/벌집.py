import sys

input = sys.stdin.readline


n = int(input())


def f(num):
    return 1 + 3 * num * (num - 1)


i = 1
while True:
    if f(i) == n:
        print(i)
        break
    if f(i) < n < f(i + 1):
        print(i + 1)
        break
    i += 1
