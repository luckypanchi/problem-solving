import sys

input = sys.stdin.readline


n, k = map(int, input().split())
points = [0] + list(map(int, input().split()))
points = points + list(reversed(points))

for i in range(1, len(points)):
    points[i] += points[i - 1]

courses = list(range(1, n + 1)) + list(range(n, 0, -1))
current = 0

for i in range(len(points) - 1):
    if points[i] <= k < points[i + 1]:
        current = courses[i]
        break

print(current)
