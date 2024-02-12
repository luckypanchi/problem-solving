import sys

input = sys.stdin.readline


x, y, w, s = map(int, input().split())

longer = max(x, y)
shorter = min(x, y)
faseter1 = min(2 * w, s)
faseter2 = min(2 * w, 2 * s)

answer = 0

if shorter > 0:
    answer += shorter * faseter1
    longer -= shorter

answer += (longer // 2) * faseter2 + (longer % 2) * w

print(answer)