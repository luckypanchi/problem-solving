import sys

input = sys.stdin.readline


n, m, length, k = map(int, input().split())
stars = [list(map(int, input().split())) for _ in range(k)]
starX = []
starY = []
for x, y in stars:
    starX.append(x)
    starY.append(y)

answer = 0
for startY in starY:
    for startX in starX:
        result = 0
        for x, y in stars:
            if startX <= x <= startX + length and startY <= y <= startY + length:
                result += 1

        answer = max(answer, result)

print(k - answer)