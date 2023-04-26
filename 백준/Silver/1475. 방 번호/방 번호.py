import sys
import math
from collections import Counter

input = sys.stdin.readline


numbers = Counter(map(int, input().strip()))
numbers[6] += numbers[9]
numbers[9] = 0

answer = 0
for num in range(9):
    if num == 6:
        answer = max(answer, int(math.ceil(numbers[num] / 2)))
    else:
        answer = max(answer, numbers[num])

print(answer)