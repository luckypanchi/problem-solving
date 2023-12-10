import sys
from collections import defaultdict

input = sys.stdin.readline


n, k = map(int, input().split())
array = list(map(int, input().split()))
accArray = [0]
for i in range(n):
    accArray.append(accArray[-1] + array[i])

indexCounter = defaultdict(int)
answer = 0

for i in range(n, 0, -1):
    curr = accArray[i]

    if curr == k:
        answer += 1

    target = curr + k
    answer += indexCounter[target]
    indexCounter[curr] += 1

print(answer)