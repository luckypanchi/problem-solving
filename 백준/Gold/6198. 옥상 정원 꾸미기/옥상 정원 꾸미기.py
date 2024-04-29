import sys

input = sys.stdin.readline


n = int(input())
heights = [int(input()) for _ in range(n)]

stack = []
answer = 0

for h in heights:
    while stack and stack[-1] <= h:
        stack.pop()
    stack.append(h)

    answer += len(stack) - 1

print(answer)