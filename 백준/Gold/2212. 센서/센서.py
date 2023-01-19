import sys

input = sys.stdin.readline


n = int(input())
k = int(input())

sensors = list(map(int, input().split()))
sensors.sort()

answer = 0

if k < n:
    dist = []
    for i in range(n - 1):
        dist.append(sensors[i + 1] - sensors[i])

    dist.sort()
    for _ in range(k - 1):
        dist.pop()
    answer = sum(dist)

print(answer)
