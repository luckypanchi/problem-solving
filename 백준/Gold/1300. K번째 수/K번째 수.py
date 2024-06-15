import sys

input = sys.stdin.readline


def count(target):
    result = 0
    for i in range(1, n + 1):
        result += min(target // i, n)
    return result


n = int(input())
k = int(input())

left = 1
right = n * n
answer = 0

while left <= right:
    mid = (left + right) // 2
    c = count(mid)

    if k <= c:
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)