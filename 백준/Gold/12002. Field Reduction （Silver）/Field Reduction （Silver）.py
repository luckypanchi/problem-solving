import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr):
    if curr == 3:
        minY = 40001
        maxY = 0
        minX = 40001
        maxX = 0
        for i in range(n):
            if not isSelected[i]:
                cowY, cowX = cows[i]
                minY = min(minY, cowY)
                maxY = max(maxY, cowY)
                minX = min(minX, cowX)
                maxX = max(maxX, cowX)

        return (maxY - minY) * (maxX - minX)

    result = INF

    for _, _, cowIndex in cows1:
        if not isSelected[cowIndex]:
            isSelected[cowIndex] = True
            result = min(result, solve(curr + 1))
            isSelected[cowIndex] = False
            break

    for _, _, cowIndex in cows1[::-1]:
        if not isSelected[cowIndex]:
            isSelected[cowIndex] = True
            result = min(result, solve(curr + 1))
            isSelected[cowIndex] = False
            break

    for _, _, cowIndex in cows2:
        if not isSelected[cowIndex]:
            isSelected[cowIndex] = True
            result = min(result, solve(curr + 1))
            isSelected[cowIndex] = False
            break

    for _, _, cowIndex in cows2[::-1]:
        if not isSelected[cowIndex]:
            isSelected[cowIndex] = True
            result = min(result, solve(curr + 1))
            isSelected[cowIndex] = False
            break

    return result


n = int(input())
cows = [list(map(int, input().split())) for _ in range(n)]
cows1 = []
cows2 = []

for i in range(n):
    cows1.append((cows[i][0], cows[i][1], i))
    cows2.append((cows[i][0], cows[i][1], i))

cows1.sort(key=lambda x: (x[0], x[1]))
cows2.sort(key=lambda x: (x[1], x[0]))


isSelected = [False] * n

print(solve(0))