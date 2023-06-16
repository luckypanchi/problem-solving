import sys

input = sys.stdin.readline


while True:
    array = list(map(int, input().split()))
    n = array[0]

    if n == 0:
        break

    heights = array[1:] + [0]
    answer = 0

    stack = []

    for i in range(n + 1):
        while stack and heights[i] < heights[stack[-1]]:
            idx = stack.pop()

            if len(stack) == 0:
                w = i
            else:
                w = i - stack[-1] - 1

            answer = max(answer, w * heights[idx])

        stack.append(i)

    print(answer)