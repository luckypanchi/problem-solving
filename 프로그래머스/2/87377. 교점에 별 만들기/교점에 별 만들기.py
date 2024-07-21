INF = float("inf")


def solution(line):
    points = []

    for i in range(len(line) - 1):
        a, b, e = line[i]
        for j in range(i + 1, len(line)):
            c, d, f = line[j]
            if a * d - b * c == 0:
                continue

            x = (b * f - e * d) / (a * d - b * c)
            y = (e * c - a * f) / (a * d - b * c)

            if x == int(x) and y == int(y):
                points.append((int(x), int(y)))

    minX = INF
    minY = INF
    maxX = -INF
    maxY = -INF

    for x, y in points:
        minX = min(minX, x)
        maxX = max(maxX, x)
        minY = min(minY, y)
        maxY = max(maxY, y)

    n = maxY - minY + 1  # 세로 길이
    m = maxX - minX + 1  # 가로 길이
    result = [["."] * m for _ in range(n)]
    for x, y in points:
        result[maxY - y][x - minX] = "*"

    return ["".join(row) for row in result]

