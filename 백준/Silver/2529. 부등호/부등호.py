import sys
from itertools import permutations


input = sys.stdin.readline

n = int(input())
matrix = list(input().split())

candidates = list(permutations(range(0, 10), n + 1))

results = []

for arr in candidates:
    stop = False
    for i in range(n):
        if matrix[i] == "<":
            if arr[i] > arr[i + 1]:
                stop = True
                break
        else:
            if arr[i] < arr[i + 1]:
                stop = True
                break

    if stop:
        continue

    results.append("".join(map(str, arr)))

print(results[-1])
print(results[0])
