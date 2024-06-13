import sys
from collections import defaultdict

input = sys.stdin.readline


def find(arr, targetY):
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == targetY:
            return True
        elif arr[mid] < targetY:
            left = mid + 1
        else:
            right = mid - 1

    return False


n = int(input())
r, c = map(int, input().split())
points = [list(map(int, input().split())) for _ in range(n)]
points.sort(key=lambda x: (x[0], x[1]))

yPerX = defaultdict(list)
for x, y in points:
    yPerX[x].append(y)

for x in yPerX:
    yPerX[x].sort()

answer = 0
for x, y in points:
    if find(yPerX[x], y + c) and find(yPerX[x + r], y) and find(yPerX[x + r], y + c):
        answer += 1

print(answer)