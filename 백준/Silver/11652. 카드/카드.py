import sys
from collections import defaultdict

input = sys.stdin.readline


n = int(input())
numbers = defaultdict(int)
for _ in range(n):
    num = int(input())
    numbers[num] += 1

numbers = sorted(numbers.items())
numbers.sort(key=lambda x: x[1], reverse=True)
print(numbers[0][0])
