import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
points = [list(map(int, input().split())) for _ in range(n)]
pointX = []
pointY = []
for x, y in points:
    pointX.append(x)
    pointY.append(y)

answers = [INF] * n

for midX in pointX:
    for midY in pointY:
        results = []
        for x, y in points:
            results.append(abs(midX - x) + abs(midY - y))
        results.sort()
        d = 0
        for i in range(n):
            d += results[i]
            answers[i] = min(answers[i], d)

print(*answers)
