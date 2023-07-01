import sys

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
videos = list(map(int, input().split()))

max_video = max(videos)
start = max_video
end = sum(videos)

answer = INF

while start <= end:
    mid = (start + end) // 2

    cnt = 1
    curr = 0

    for i in range(n):
        if curr + videos[i] <= mid:
            curr += videos[i]
        else:
            cnt += 1
            curr = videos[i]

        if m < cnt:
            break

    if m < cnt:
        start = mid + 1
    else:
        end = mid - 1
        if max_video <= mid:
            answer = min(answer, mid)

print(answer)