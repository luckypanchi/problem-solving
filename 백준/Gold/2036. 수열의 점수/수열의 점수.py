import sys

input = sys.stdin.readline


n = int(input())
answer = 0
positive = []
negative = []

for _ in range(n):
    number = int(input())
    if number == 1:
        answer += 1
    elif number > 0:
        positive.append(number)
    else:
        negative.append(number)

positive.sort(reverse=True)
negative.sort()

for i in range(0, 2 * (len(positive) // 2), 2):
    answer += positive[i] * positive[i + 1]

if len(positive) % 2 != 0:
    answer += positive[-1]

for i in range(0, 2 * (len(negative) // 2), 2):
    answer += negative[i] * negative[i + 1]

if len(negative) % 2 != 0:
    answer += negative[-1]

print(answer)