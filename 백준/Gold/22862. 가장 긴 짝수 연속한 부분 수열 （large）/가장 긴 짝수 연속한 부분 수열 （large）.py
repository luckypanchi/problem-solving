import sys

input = sys.stdin.readline


n, k = map(int, input().split())
numbers = list(map(int, input().split()))

left, right = 0, 0
answer = 0
count = 0

while left < n and right < n:
    if numbers[left] % 2 != 0:
        left += 1
        right = max(left, right)
        count = max(0, count - 1)
    elif numbers[right] % 2 == 0:
        answer = max(answer, right + 1 - left - count)
        right += 1
    elif count < k:
        right += 1
        count += 1
    else:
        left += 1


print(answer)