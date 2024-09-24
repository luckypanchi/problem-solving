import sys

input = sys.stdin.readline


def get_dist_square(x1, y1, x2, y2):
    return (x1 - x2) ** 2 + (y1 - y2) ** 2


n = int(input())
points = [list(map(int, input().split())) for _ in range(n)]

answer = 0
for i in range(n):
    for j in range(i + 1, n):
        for k in range(j + 1, n):
            x1, y1 = points[i]
            x2, y2 = points[j]
            x3, y3 = points[k]

            d1 = get_dist_square(x1, y1, x2, y2)
            d2 = get_dist_square(x2, y2, x3, y3)
            d3 = get_dist_square(x3, y3, x1, y1)

            if d1 + d2 == d3 or d2 + d3 == d1 or d1 + d3 == d2:
                answer += 1

print(answer)