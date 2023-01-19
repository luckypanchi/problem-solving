import sys
from collections import Counter

input = sys.stdin.readline


n = int(input())
numbers = sorted([int(input()) for _ in range(n)])

print(round(sum(numbers) / len(numbers)))
print(numbers[len(numbers) // 2])

counter = Counter(numbers)
MAX = -1
result = []
for n in counter:
    if MAX < counter[n]:
        MAX = counter[n]
        result = [n]
    elif MAX == counter[n]:
        result.append(n)

result.sort()
if len(result) == 1:
    print(result[0])
else:
    print(result[1])

print(numbers[-1] - numbers[0])
