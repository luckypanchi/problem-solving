import sys

input = sys.stdin.readline


n, k = map(int, input().split())
scores = list(map(int, input().split()))

answer = 0

left, right = min(scores), sum(scores)

while left <= right:
    score, group_cnt = 0, 0

    mid = (left + right) // 2

    for s in scores:
        if score + s < mid:
            score += s
        else:
            score = 0
            group_cnt += 1

    if group_cnt < k:
        right = mid - 1
    else:
        answer = mid
        left = mid + 1

print(answer)