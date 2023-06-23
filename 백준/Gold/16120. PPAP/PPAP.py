import sys

input = sys.stdin.readline


string = list(input().strip())

stack = []

for s in string:
    if s == "P" and 3 <= len(stack) and stack[-1] == "A" and stack[-2] == "P" and stack[-3] == "P":
        stack.pop()
        stack.pop()
    else:
        stack.append(s)

if len(stack) == 1 and stack[0] == "P":
    print("PPAP")
else:
    print("NP")