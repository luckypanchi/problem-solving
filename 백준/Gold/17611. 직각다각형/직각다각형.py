import sys

input = sys.stdin.readline

LEN = 500000


n = int(input())
points = []
for _ in range(n):
    x, y = map(int, input().split())
    points.append((x + LEN, y + LEN))
points.append(points[0])

yPrefix = [0] * (2 * LEN + 1)
xPrefix = [0] * (2 * LEN + 1)

for i in range(n):
    x1, y1 = points[i]
    x2, y2 = points[i + 1]
    if x1 == x2:
        maxY = max(y1, y2)
        minY = min(y1, y2)
        yPrefix[minY] += 1
        yPrefix[maxY] -= 1
    else:
        maxX = max(x1, x2)
        minX = min(x1, x2)
        xPrefix[minX] += 1
        xPrefix[maxX] -= 1

for i in range(1, 2 * LEN + 1):
    xPrefix[i] += xPrefix[i - 1]
    yPrefix[i] += yPrefix[i - 1]

answer = max(max(xPrefix), max(yPrefix))

print(answer)