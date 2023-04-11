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


def print_point():
    mod = (x1 - x2) * (b1 - b2) - (y1 - y2) * (a1 - a2)
    if mod == 0:
        if min(x1, x2) == max(a1, a2) or min(a1, a2) == max(x1, x2):
            if (x1, y1) == (a1, b1) or (x1, y1) == (a2, b2):
                print(x1, y1)
            elif (x2, y2) == (a1, b1) or (x2, y2) == (a2, b2):
                print(x2, y2)

    else:
        x = (x1 * y2 - y1 * x2) * (a1 - a2) - (x1 - x2) * (a1 * b2 - b1 * a2)
        x /= mod
        y = (x1 * y2 - y1 * x2) * (b1 - b2) - (y1 - y2) * (a1 * b2 - b1 * a2)
        y /= mod

        if x % 1 == 0:
            x = int(x)
        if y % 1 == 0:
            y = int(y)

        print(x, y)


x1, y1, x2, y2 = map(int, input().split())
a1, b1, a2, b2 = map(int, input().split())

xy = ccw(x1, y1, x2, y2, a1, b1) * ccw(x1, y1, x2, y2, a2, b2)
ab = ccw(a1, b1, a2, b2, x1, y1) * ccw(a1, b1, a2, b2, x2, y2)


if xy == 0 and ab == 0:
    if (
        min(x1, x2) <= max(a1, a2)
        and min(y1, y2) <= max(b1, b2)
        and min(a1, a2) <= max(x1, x2)
        and min(b1, b2) <= max(y1, y2)
    ):
        print(1)
        print_point()

    else:
        print(0)

elif xy <= 0 and ab <= 0:
    print(1)
    print_point()

else:
    print(0)