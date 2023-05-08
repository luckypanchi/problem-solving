import sys
from itertools import combinations

input = sys.stdin.readline

INF = float("inf")


tc = int(input())
for _ in range(tc):
    n = int(input())
    points = []

    x_total = 0
    y_total = 0
    for _ in range(n):
        x, y = map(int, input().split())
        x_total += x
        y_total += y
        points.append([x, y])

    answer = INF
    combs = list(combinations(points, n // 2))
    length = len(combs) // 2
    for comb in combs[:length]:
        comb = list(comb)

        x_plus = 0
        y_plus = 0
        for x, y in comb:
            x_plus += x
            y_plus += y

        x_minus = x_total - x_plus
        y_minus = y_total - y_plus

        answer = min(answer, ((x_plus - x_minus) ** 2 + (y_plus - y_minus) ** 2) ** 0.5)

    print(answer)