import sys

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    min_r = min(r1, r2)
    max_r = max(r1, r2)
    d = ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** (1 / 2)

    if (x1, y1, r1) == (x2, y2, r2):
        answer = -1
    elif min_r + max_r < d:
        answer = 0
    elif min_r + max_r == d:
        answer = 1
    elif max_r - min_r < d < max_r + min_r:
        answer = 2
    elif max_r - min_r == d:
        answer = 1
    elif max_r - min_r > d:
        answer = 0

    print(answer)