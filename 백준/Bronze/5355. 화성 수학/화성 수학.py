import sys

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    array = list(input().split())
    n = float(array[0])

    for i in range(1, len(array)):
        s = array[i]
        if s == "@":
            n *= 3
        elif s == "%":
            n += 5
        elif s == "#":
            n -= 7

    print("{:.2f}".format(n))