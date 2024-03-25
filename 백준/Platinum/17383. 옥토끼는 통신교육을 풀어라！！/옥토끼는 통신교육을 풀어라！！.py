import sys
import math

input = sys.stdin.readline


def check(blockSize):
    savedBlock = 0

    for i in range(n):
        if costs[i] <= blockSize:
            savedBlock += 1
            continue

        currSize = math.ceil(costs[i] / blockSize)
        if savedBlock < currSize - 1:
            return False

        savedBlock -= currSize - 1
        savedBlock += 1

    return True


n = int(input())
costs = sorted(list(map(int, input().split())))

left, right = 1, costs[-1]
answer = 0
while left <= right:
    mid = (left + right) // 2
    if check(mid):
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)