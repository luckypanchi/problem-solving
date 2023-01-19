import sys

input = sys.stdin.readline


answer = []

while True:
    string = input().rstrip()

    if string == ".":
        break

    stack = []

    for s in string:
        if s == ".":
            break
        if s in "()[]":
            if len(stack) != 0 and stack[-1] == "(" and s == ")":
                stack.pop()
            elif len(stack) != 0 and stack[-1] == "[" and s == "]":
                stack.pop()
            else:
                stack.append(s)

    if len(stack) == 0:
        answer.append("yes")
    else:
        answer.append("no")

for a in answer:
    print(a)
