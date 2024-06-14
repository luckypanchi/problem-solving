import sys
import math

input = sys.stdin.readline


def count(jealous):
    result = 0
    for gem in gems:
        result += math.ceil(gem / jealous)
    return result


n, m = map(int, input().split())
gems = sorted([int(input()) for _ in range(m)])

left = 1
right = gems[-1]
answer = 0
while left <= right:
    mid = (left + right) // 2
    c = count(mid)
    if c <= n:
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)