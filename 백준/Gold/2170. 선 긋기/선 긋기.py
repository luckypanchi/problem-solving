import sys

input = sys.stdin.readline


n = int(input())
lines = []
for _ in range(n):
    a, b = map(int, input().split())
    lines.append([min(a, b), max(a, b)])
lines.sort(key=lambda x: (x[0], x[1]))

answer = 0
start, end = lines[0]
for i in range(1, n):
    currStart, currEnd = lines[i]

    if currEnd <= end:
        continue
    if currStart <= end:
        end = currEnd
    else:
        answer += end - start
        start, end = currStart, currEnd

answer += end - start

print(answer)