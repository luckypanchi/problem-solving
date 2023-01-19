import sys

input = sys.stdin.readline


n, c = map(int, input().split())
houses = sorted([int(input()) for _ in range(n)])

start = 1
end = houses[-1] - houses[0]

while start <= end:
    mid = (start + end) // 2
    house = houses[0]
    cnt = 1
    for i in range(1, n):
        if house + mid <= houses[i]:
            cnt += 1
            house = houses[i]

    if cnt >= c:
        start = mid + 1
    else:
        end = mid - 1

print(start - 1)
