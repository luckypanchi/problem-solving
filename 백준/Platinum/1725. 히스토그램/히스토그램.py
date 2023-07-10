import sys

input = sys.stdin.readline


n = int(input())
heights = [int(input()) for _ in range(n)]

stack = []
answer = 0

for i in range(n):
    left = i
    while stack and heights[i] < heights[stack[-1]]:
        h = heights[stack.pop()]

        if len(stack) == 0:
            w = i
        else:
            w = i - 1 - stack[-1]

        answer = max(answer, h * w)

    stack.append(i)

while stack:
    h = heights[stack.pop()]

    if len(stack) == 0:
        w = n
    else:
        w = n - 1 - stack[-1]

    answer = max(answer, h * w)

print(answer)