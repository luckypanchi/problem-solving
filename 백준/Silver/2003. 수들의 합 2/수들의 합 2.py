import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = [0] + list(map(int, input().split()))
prefixSum = [0] * (n + 1)
for i in range(1, n + 1):
    prefixSum[i] = prefixSum[i - 1] + numbers[i]

answer = 0
start = 1
end = 1
while end < n + 1:
    s = prefixSum[end] - prefixSum[start - 1]
    if s == m:
        start += 1
        end += 1
        answer += 1
    elif s < m:
        end += 1
    else:
        start += 1

print(answer)