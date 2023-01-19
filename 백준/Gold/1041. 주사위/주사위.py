import sys

input = sys.stdin.readline


n = int(input())

tmp = list(map(int, input().split()))
numbers = []

for i in range(3):
    numbers.append(min(tmp[i], tmp[5 - i]))

numbers.sort()

answer = 0

if n == 1:
    answer = sum(tmp) - max(tmp)

else:
    answer = (
        numbers[0] * (4 * (n - 2) * (n - 1) + (n - 2) * (n - 2))
        + (numbers[0] + numbers[1]) * (4 * (n - 1) + 4 * (n - 2))
        + (sum(numbers)) * 4
    )

print(answer)
