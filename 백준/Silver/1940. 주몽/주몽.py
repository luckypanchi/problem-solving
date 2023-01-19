import sys

input = sys.stdin.readline


n = int(input())
m = int(input())
numbers = sorted(list(map(int, input().split())))

answer = 0
left, right = 0, n - 1

while left < right:
    s = numbers[left] + numbers[right]
    if s == m:
        answer += 1
        left += 1
        right -= 1
    elif s > m:
        right -= 1
    else:
        left += 1

print(answer)
