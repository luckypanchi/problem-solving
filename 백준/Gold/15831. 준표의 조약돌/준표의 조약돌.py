import sys

input = sys.stdin.readline


n, b, w = map(int, input().split())
rocks = list(input().strip())

left = 0
right = 0
whiteCount = 0
blackCount = 0
answer = 0

while right < n:
    if b < blackCount:
        if rocks[left] == "W":
            whiteCount -= 1
        if rocks[left] == "B":
            blackCount -= 1
        left += 1
    elif rocks[right] == "W":
        whiteCount += 1
        right += 1
    elif rocks[right] == "B":
        blackCount += 1
        right += 1

    if blackCount <= b and w <= whiteCount:
        answer = max(answer, right - left)

print(answer)