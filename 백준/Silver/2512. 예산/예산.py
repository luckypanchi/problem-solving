import sys

input = sys.stdin.readline


n = int(input())
reqs = list(map(int, input().split()))
total = int(input())

answer = 0

if sum(reqs) <= total:
    answer = max(reqs)
else:
    reqs.sort()
    start = 0
    end = reqs[-1]
    while start <= end:
        mid = (start + end) // 2

        result = 0
        for r in reqs:
            result += min(r, mid)

        if result <= total:
            start = mid + 1
        else:
            end = mid - 1
    answer = end


print(answer)
