import sys
from collections import defaultdict

input = sys.stdin.readline


n = int(input())
numbers = list(map(int, input().split()))

sorted_numbers = sorted(list(set(numbers)))
idx = 0
convert = defaultdict(int)
for num in sorted_numbers:
    convert[num] += idx
    idx += 1


answer = [convert[x] for x in numbers]

print(*answer)
