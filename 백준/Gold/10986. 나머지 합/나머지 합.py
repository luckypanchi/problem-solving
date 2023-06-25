import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = list(map(int, input().split()))

remainder = [0] * m
remainder[0] = 1

total = 0
for i in range(n):
    total += numbers[i]
    remainder[total % m] += 1

answer = 0
for cnt in remainder:
    answer += cnt * (cnt - 1) // 2

print(answer)