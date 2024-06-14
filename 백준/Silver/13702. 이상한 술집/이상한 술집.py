import sys

input = sys.stdin.readline


def count(ml):
    result = 0
    for mak in maks:
        result += mak // ml
    return result


n, k = map(int, input().split())
maks = sorted([int(input()) for _ in range(n)])

left = 1
right = maks[-1]
answer = 0

while left <= right:
    mid = (left + right) // 2
    c = count(mid)
    if c < k:
        right = mid - 1
    else:
        answer = mid
        left = mid + 1

print(answer)
