import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
array = sorted([int(input()) for _ in range(n)])

answer = INF
for i in range(n):
    currCount = 0
    idx = i + 1
    for j in range(1, 5):
        target = array[i] + j
        if idx < n and array[idx] == target:
            idx += 1
        else:
            currCount += 1

    answer = min(answer, currCount)


print(answer)