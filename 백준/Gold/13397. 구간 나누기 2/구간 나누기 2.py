import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = list(map(int, input().split()))

start, end = 0, max(numbers)
answer = 0
while start <= end:
    mid = (start + end) // 2
    min_n, max_n = 10001, 0
    cnt = 0
    for i in range(n):
        max_n = max(max_n, numbers[i])
        min_n = min(min_n, numbers[i])
        if max_n - min_n > mid:
            cnt += 1
            min_n, max_n = numbers[i], numbers[i]

    if cnt >= m:
        start = mid + 1
    else:
        end = mid - 1

print(start)
