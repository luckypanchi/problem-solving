import sys

input = sys.stdin.readline

INF = float("inf")


distances = [[INF] * 8 for _ in range(8)]
points = []

sy, sx = map(int, input().split())
ey, ex = map(int, input().split())

points.append((sy, sx))

distances[0][7] = abs(ey - sy) + abs(ex - sx)
distances[7][0] = distances[0][7]

for i in range(1, 7, 2):
    y1, x1, y2, x2 = map(int, input().split())
    distances[i][i + 1] = min(abs(y1 - y2) + abs(x1 - x2), 10)
    distances[i + 1][i] = distances[i][i + 1]

    points.append((y1, x1))
    points.append((y2, x2))

points.append((ey, ex))

for i in range(8):
    for j in range(8):
        distances[i][j] = min(distances[i][j], abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]))

for k in range(8):
    for i in range(8):
        for j in range(8):
            distances[i][j] = min(distances[i][j], distances[i][k] + distances[k][j])

print(distances[0][7])