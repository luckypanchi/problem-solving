import sys

input = sys.stdin.readline

tc = int(input())

for _ in range(tc):
    string = input().strip()

    stack = []

    for s in string:
        if stack:
            if stack[-1] == "(" and s == ")":
                stack.pop()
                continue
        stack.append(s)

    if stack:
        print("NO")
    else:
        print("YES")
