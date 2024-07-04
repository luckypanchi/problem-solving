import sys

input = sys.stdin.readline


string = input().strip()

stack = []

for s in string:
    if stack and stack[-1] == "(" and s == ")":
        stack.pop()
    else:
        stack.append(s)

print(len(stack))