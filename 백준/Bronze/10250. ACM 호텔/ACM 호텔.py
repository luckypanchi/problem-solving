import sys

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    h, w, n = map(int, input().split())

    if n % h == 0:
        y = h
        x = n // h

    else:
        y = n % h
        x = n // h + 1

    print(y * 100 + x)
