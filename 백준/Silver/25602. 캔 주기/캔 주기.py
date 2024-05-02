import sys

input = sys.stdin.readline


def solve(day, cat1, cat2):
    global answer
    if day == k:
        answer = max(answer, cat1 + cat2)
        return

    for i in range(n):
        if canCounts[i] > 0:
            canCounts[i] -= 1
            for j in range(n):
                if canCounts[j] > 0:
                    canCounts[j] -= 1
                    solve(day + 1, cat1 + r[day][i], cat2 + m[day][j])
                    canCounts[j] += 1
            canCounts[i] += 1


n, k = map(int, input().split())
canCounts = list(map(int, input().split()))
r = [list(map(int, input().split())) for _ in range(k)]
m = [list(map(int, input().split())) for _ in range(k)]

answer = 0
solve(0, 0, 0)

print(answer)