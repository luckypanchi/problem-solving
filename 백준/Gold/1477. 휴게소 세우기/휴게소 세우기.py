import sys

input = sys.stdin.readline


n, m, l = map(int, input().split())
array = [0] + sorted(list(map(int, input().split()))) + [l]

start, end = 1, l - 1
answer = 0

while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in range(n + 1):
        if array[i + 1] - array[i] > mid:
            cnt += (array[i + 1] - array[i] - 1) // mid

    if m < cnt:
        start = mid + 1
    else:
        end = mid - 1
        result = mid

print(end + 1)
