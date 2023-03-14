import sys

input = sys.stdin.readline


n = int(input())
stack = []
answer = []
num = 1
flag = False

for _ in range(n):
    target = int(input())

    while num <= target:
        stack.append(num)
        answer.append("+")
        num += 1

    if stack[-1] == target:
        stack.pop()
        answer.append("-")
    else:
        flag = True
        break

if flag:
    print("NO")
else:
    for ans in answer:
        print(ans)