import sys

input = sys.stdin.readline

target = input().strip()
bomb = list(input().strip())
len_bomb = len(bomb)

stack = []

for c in target:
    stack.append(c)

    if stack[-len_bomb:] == bomb:
        for _ in range(len_bomb):
            stack.pop()

if stack:
    print("".join(stack))
else:
    print("FRULA")
