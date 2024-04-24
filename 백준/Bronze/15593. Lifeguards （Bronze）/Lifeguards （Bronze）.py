import sys

input = sys.stdin.readline


n = int(input())
timeCovers = [list(map(int, input().split())) for _ in range(n)]

answer = 0
for target in range(n):
    timeTable = [False] * 1001
    for i in range(n):
        if i == target:
            continue
        for t in range(timeCovers[i][0], timeCovers[i][1]):
            timeTable[t] = True

    answer = max(answer, timeTable.count(True))

print(answer)