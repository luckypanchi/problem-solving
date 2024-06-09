import sys

input = sys.stdin.readline


heights = [int(input()) for _ in range(9)]
heights.sort()


left = 0
right = len(heights) - 1
currSum = sum(heights) - heights[left] - heights[right]

while left < right:
    if currSum == 100:
        break
    elif currSum < 100:
        currSum += heights[right]
        right -= 1
        currSum -= heights[right]
    else:
        currSum += heights[left]
        left += 1
        currSum -= heights[left]

for i in range(len(heights)):
    if i != left and i != right:
        print(heights[i])