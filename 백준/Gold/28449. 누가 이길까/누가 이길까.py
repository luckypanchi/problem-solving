import sys

input = sys.stdin.readline


def lowerBound(target):
    left = 0
    right = m - 1

    while left < right:
        mid = (left + right) // 2
        if arcList[mid] < target:
            left = mid + 1
        else:
            right = mid

    return left


def upperBound(target):
    left = 0
    right = m

    while left < right:
        mid = (left + right) // 2
        if target < arcList[mid]:
            right = mid
        else:
            left = mid + 1

    return left


n, m = map(int, input().split())
hiList = sorted(list(map(int, input().split())))
arcList = sorted(list(map(int, input().split())))

hiWinCount = 0
arcWinCount = 0
drawCount = 0

for hi in hiList:
    if hi < arcList[0]:
        arcWinCount += m
        continue

    elif arcList[-1] < hi:
        hiWinCount += m
        continue

    lower = lowerBound(hi)
    upper = upperBound(hi)

    hiWinCount += lower
    arcWinCount += m - upper

    if arcList[lower] == hi:
        drawCount += upper - lower

print(hiWinCount, arcWinCount, drawCount)