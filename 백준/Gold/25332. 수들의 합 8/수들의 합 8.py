import sys
from collections import defaultdict

input = sys.stdin.readline


n = int(input())
aList = [0] + list(map(int, input().split()))
bList = [0] + list(map(int, input().split()))

prefixSum = [0] * (n + 1)
for i in range(1, n + 1):
    prefixSum[i] = prefixSum[i - 1] + aList[i] - bList[i]

counter = defaultdict(int)
answer = 0

for i in range(n, 0, -1):
    v = prefixSum[i]

    if v == 0:
        answer += 1

    answer += counter[v]
    counter[v] += 1

print(answer)