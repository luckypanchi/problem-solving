import sys
from collections import Counter

input = sys.stdin.readline


n = int(input())
numbers = sorted(list(map(int, input().split())))
counter = Counter(numbers)

answer = 0

for i in range(n - 2):
    left, right = i + 1, n - 1
    target = -numbers[i]

    while left < right:
        result = numbers[left] + numbers[right]

        if result < target:
            left += 1
        elif result == target:
            if numbers[left] == numbers[right]:
                answer += right - left
            else:
                answer += counter[numbers[right]]
            left += 1
        else:
            right -= 1

print(answer)