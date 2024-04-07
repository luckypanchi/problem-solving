import sys

input = sys.stdin.readline


n, k = map(int, input().split())
accSum = [0] * 1000002
counts = [0] * 1000002
MAX = -1

for _ in range(n):
    start, end = map(int, input().split())
    counts[start] += 1
    counts[end] -= 1
    MAX = max(MAX, end)

currCount = counts[0]
for i in range(1, 1000002):
    accSum[i] = accSum[i - 1] + currCount
    currCount += counts[i]

left, right = 0, 0
while left < MAX + 1 and right < MAX + 1:
    s = accSum[right] - accSum[left]
    if s == k:
        break
    elif s < k:
        right += 1
    else:
        left += 1

if s == k:
    print(left, right)
else:
    print(0, 0)