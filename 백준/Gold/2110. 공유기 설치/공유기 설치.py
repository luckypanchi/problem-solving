import sys

input = sys.stdin.readline


def count(distance):
    result = 1
    start = houses[0]
    for i in range(1, n):
        if start + distance <= houses[i]:
            result += 1
            start = houses[i]
    return result


n, c = map(int, input().split())
houses = sorted([int(input()) for _ in range(n)])

left = 1
right = houses[-1]
answer = 0

while left <= right:
    mid = (left + right) // 2
    if c <= count(mid):
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)