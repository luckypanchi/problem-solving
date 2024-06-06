import sys

input = sys.stdin.readline


g = int(input())
answer = []
for num1 in range(1, int(g**0.5) + 1):
    if g % num1 == 0:
        num2 = g // num1
        if num1 == num2:
            continue

        if (num2 + num1) % 2 == 0 and (num2 - num1) % 2 == 0:
            answer.append((num2 + num1) // 2)

answer.sort()
if len(answer) == 0:
    print(-1)
else:
    print(*answer, sep="\n")