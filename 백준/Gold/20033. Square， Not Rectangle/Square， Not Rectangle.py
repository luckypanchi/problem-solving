import sys

input = sys.stdin.readline


def count(targetHeight):
    result = 0
    currCount = 0
    for h in heights:
        if targetHeight <= h:
            currCount += 1
        else:
            result = max(result, currCount)
            currCount = 0

    result = max(result, currCount)
    return result


n = int(input())
heights = list(map(int, input().split()))

left = 1
right = max(heights)
answer = 1

while left <= right:
    mid = (left + right) // 2
    longest = count(mid)

    if mid <= longest:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)
