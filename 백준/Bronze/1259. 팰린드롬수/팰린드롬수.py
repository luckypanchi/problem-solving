import sys

input = sys.stdin.readline


while True:
    n = list(map(int, input().strip()))

    if n == [0]:
        break

    if n == n[::-1]:
        print("yes")
    else:
        print("no")