import sys

input = sys.stdin.readline


stack1 = list(input().strip())
stack2 = []
m = int(input())

for _ in range(m):
    cmd = input().strip()
    if cmd[0] == "P":
        _, p = cmd.split()
        stack1.append(p)
    elif cmd == "L":
        if stack1:
            stack2.append(stack1.pop())
    elif cmd == "D":
        if stack2:
            stack1.append(stack2.pop())
    elif cmd == "B":
        if stack1:
            stack1.pop()

answer = "".join(stack1 + stack2[::-1])

print(answer)
