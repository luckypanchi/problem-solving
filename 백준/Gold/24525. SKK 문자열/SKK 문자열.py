import sys

input = sys.stdin.readline


string = [0] + list(input().strip())

n = len(string) - 1
prefixSum = [0] * (n + 1)
count = [0] * (n + 1)

for i in range(1, n + 1):
    if string[i] == "S":
        prefixSum[i] = 2
        count[i] = 1
    elif string[i] == "K":
        prefixSum[i] = -1
        count[i] = 1

for i in range(1, n + 1):
    prefixSum[i] += prefixSum[i - 1]
    count[i] += count[i - 1]

answer = -1
entryIndex = [n] * (2 * n + 1)
exitIndex = [-1] * (2 * n + 1)

for i in range(n + 1):
    v = prefixSum[i]
    entryIndex[v] = min(entryIndex[v], i)
    exitIndex[v] = max(exitIndex[v], i)

for v in range(2 * n + 1):
    if entryIndex[v] != exitIndex[v] and count[entryIndex[v]] != count[exitIndex[v]]:
        answer = max(answer, exitIndex[v] - entryIndex[v])

print(answer)