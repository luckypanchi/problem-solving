import sys

input = sys.stdin.readline


n = int(input())
assignments = [list(map(int, input().split())) for _ in range(n)]

assignments.sort()
max_day = assignments[-1][0]

answer = 0
points = []

for day in range(max_day, 0, -1):
    while assignments and day <= assignments[-1][0]:
        points.append(assignments.pop()[1])

    if points:
        points.sort()
        answer += points.pop()

print(answer)
