import sys

input = sys.stdin.readline


n, m = map(int, input().split())
times = sorted([int(input()) for _ in range(n)])

start, end = times[0], times[-1] * m
while start <= end:
    mid = (start + end) // 2
    p_cnt = 0
    for t in times:
        p_cnt += mid // t
    if p_cnt < m:
        start = mid + 1
    else:
        end = mid - 1

print(start)
