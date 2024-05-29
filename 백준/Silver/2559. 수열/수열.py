import sys

input = sys.stdin.readline

INF = float("inf")


n, k = map(int, input().split())
temps = [0] + list(map(int, input().split()))
prefixSum = [0] * (n + 1)
for i in range(1, n + 1):
    prefixSum[i] = temps[i] + prefixSum[i - 1]

answer = -INF
for i in range(k, n + 1):
    answer = max(answer, prefixSum[i] - prefixSum[i - k])

print(answer)
