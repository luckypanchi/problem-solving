import sys

input = sys.stdin.readline

n, k = map(int, input().split())

numbers = list(map(int, input().strip()))

stack = []
cnt = 0

for num in numbers:
    while len(stack) != 0 and stack[-1] < num and cnt < k:
        cnt += 1
        stack.pop()

    stack.append(num)

while cnt < k:
    cnt += 1
    stack.pop()

print("".join(str(s) for s in stack))
