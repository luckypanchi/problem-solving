import sys

input = sys.stdin.readline

numbers = [int(input()) for _ in range(5)]

print(sum(numbers) // 5)

numbers.sort()
print(numbers[2])