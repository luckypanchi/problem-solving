import sys

input = sys.stdin.readline


def ccw(x1, y1, x2, y2, a, b):
    cp = x1 * y2 + x2 * b + a * y1 - x2 * y1 - a * y2 - x1 * b

    if cp < 0:
        return -1
    elif cp == 0:
        return 0
    else:
        return 1


x1, y1, x2, y2 = map(int, input().split())
a1, b1, a2, b2 = map(int, input().split())


xy = ccw(x1, y1, x2, y2, a1, b1) * ccw(x1, y1, x2, y2, a2, b2)
ab = ccw(a1, b1, a2, b2, x1, y1) * ccw(a1, b1, a2, b2, x2, y2)

if xy <= 0 and ab <= 0:
    print(1)
else:
    print(0)