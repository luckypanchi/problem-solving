import sys

input = sys.stdin.readline


n, s, r = map(int, input().split())
teams = [1] * (n + 1)
broken = list(map(int, input().split()))
for t in broken:
    teams[t] = 0
more = list(map(int, input().split()))
for t in more:
    if teams[t] == 0:
        teams[t] = 1
    else:
        teams[t] = 2

answer = 0
for i in range(1, n + 1):
    if teams[i] != 0:
        continue

    if 1 <= i - 1 and teams[i - 1] == 2:
        teams[i - 1] = 1
        teams[i] = 1
        continue

    if i + 1 < n + 1 and teams[i + 1] == 2:
        teams[i + 1] = 1
        teams[i] = 1
        continue

    answer += 1


print(answer)