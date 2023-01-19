import sys

input = sys.stdin.readline

n, k = map(int, input().split())
heights = list(map(int, input().split()))

diffs = []
for i in range(n - 1):
    diffs.append(heights[i + 1] - heights[i])

diffs.sort()

answer = sum(diffs)
for _ in range(k - 1):
    answer -= diffs.pop()

print(answer)
