import sys

input = sys.stdin.readline


n = int(input())
pointX = []
pointY = []
for _ in range(n):
    x, y = map(int, input().split())
    pointX.append(x)
    pointY.append(y)

pointX.sort()
pointY.sort()
midX = pointX[n // 2]
midY = pointY[n // 2]

answer = 0
for i in range(n):
    answer += abs(midX - pointX[i]) + abs(midY - pointY[i])

print(answer)