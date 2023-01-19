import sys

input = sys.stdin.readline

n = int(input())

numbers = [1] * 10

for _ in range(n - 1):
    for i in range(1, 10):
        numbers[i] += numbers[i - 1]


print(sum(numbers) % 10007)
