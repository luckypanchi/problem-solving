import sys

input = sys.stdin.readline


def count(pivot):
    result = 0
    for cable in cables:
        result += cable // pivot
    return result


k, n = map(int, input().split())
cables = sorted([int(input()) for _ in range(k)])

left = 1
right = cables[-1]
answer = 0

while left <= right:
    mid = (left + right) // 2
    c = count(mid)
    if c < n:
        right = mid - 1
    else:
        answer = mid
        left = mid + 1

print(answer)