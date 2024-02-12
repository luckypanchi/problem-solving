import sys

input = sys.stdin.readline

INF = float("inf")


n, m, k = map(int, input().split())
points = list(map(int, input().split()))

minLength = INF
start, end = 0, points[-1] - points[0]
while start <= end:
    mid = (start + end) // 2

    prev = points[0]
    cnt = 1
    for i in range(1, k):
        if points[i] - prev >= mid:
            cnt += 1
            prev = points[i]

    if cnt >= m:
        start = mid + 1
        minLength = mid
    else:
        end = mid - 1

prev = points[0]
cnt = 1
answer = "1"

for i in range(1, k):
    if points[i] - prev >= minLength and cnt < m:
        answer += "1"
        cnt += 1
        prev = points[i]
    else:
        answer += "0"

print(answer)