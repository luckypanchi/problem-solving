import sys

input = sys.stdin.readline


tc = int(input())
a, b, c, d, e = 0, 0, 0, 0, 0

for _ in range(tc):
    x, y = map(int, input().split())
    if x == 0 or y == 0:
        e += 1
    elif x > 0 and y > 0:
        a += 1
    elif x < 0 and y > 0:
        b += 1
    elif x < 0 and y < 0:
        c += 1
    elif x > 0 and y < 0:
        d += 1


print("Q1:", a)
print("Q2:", b)
print("Q3:", c)
print("Q4:", d)
print("AXIS:", e)