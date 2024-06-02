import sys

input = sys.stdin.readline


n, m = map(int, input().split())
heights = [0] + list(map(int, input().split()))
prefixSum = [0] * (n + 2)
for _ in range(m):
    a, b, k = map(int, input().split())
    prefixSum[a] += k
    prefixSum[b + 1] -= k

for i in range(1, n + 1):
    prefixSum[i] += prefixSum[i - 1]

for i in range(1, n + 1):
    heights[i] += prefixSum[i]

print(*heights[1:])