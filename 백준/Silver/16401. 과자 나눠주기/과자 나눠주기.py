import sys

input = sys.stdin.readline


def count(length):
    cnt = 0
    for snack in snacks:
        cnt += snack // length
    return cnt


m, n = map(int, input().split())
snacks = list(map(int, input().split()))

start = 1
end = max(snacks)

answer = 0

while start <= end:
    mid = (start + end) // 2
    if m <= count(mid):
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)