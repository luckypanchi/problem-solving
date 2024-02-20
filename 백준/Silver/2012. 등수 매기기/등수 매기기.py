import sys

input = sys.stdin.readline


N = int(input())
numbers = sorted([int(input()) for _ in range(N)])

answer = 0
for i in range(len(numbers)):
    answer += abs(i + 1 - numbers[i])

print(answer)