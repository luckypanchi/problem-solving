import sys

input = sys.stdin.readline


string = list(input().strip())
stack = []
answer = ""

for s in string:
    if s.isalpha():
        answer += s

    elif s == "(":
        stack.append(s)
    elif s in ("*", "/"):
        while stack and stack[-1] in ("*", "/"):
            answer += stack.pop()
        stack.append(s)
    elif s in ("+", "-"):
        while stack and stack[-1] != "(":
            answer += stack.pop()
        stack.append(s)
    elif s == ")":
        while stack and stack[-1] != "(":
            answer += stack.pop()
        stack.pop()

while stack:
    answer += stack.pop()

print(answer)