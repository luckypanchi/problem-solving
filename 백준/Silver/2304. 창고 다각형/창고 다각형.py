import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
warehouses = [list(map(int, input().split())) for _ in range(n)]

maxHeight = sorted(warehouses, key=lambda x: x[1])[-1][1]

answer = 0
for height in range(1, maxHeight + 1):
    left = INF
    right = 0
    for pos, h in warehouses:
        if height <= h:
            left = min(left, pos)
            right = max(right, pos + 1)
    answer += right - left

print(answer)