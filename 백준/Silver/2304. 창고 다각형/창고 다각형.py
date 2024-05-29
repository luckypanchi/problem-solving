import sys

input = sys.stdin.readline


n = int(input())
prefixSum = [0] * 1002
suffixSum = [0] * 1002

for _ in range(n):
    x, h = map(int, input().split())
    prefixSum[x] = h
    suffixSum[x] = h

for i in range(1, 1002):
    j = 1000 - i + 1
    prefixSum[i] = max(prefixSum[i], prefixSum[i - 1])
    suffixSum[j] = max(suffixSum[j], suffixSum[j + 1])

answer = 0
for i in range(1, 1001):
    answer += min(prefixSum[i], suffixSum[i])

print(answer)
