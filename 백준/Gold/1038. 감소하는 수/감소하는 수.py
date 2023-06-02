import sys
from itertools import combinations

input = sys.stdin.readline


n = int(input())
results = []

for i in range(1, 11):
    for j in combinations(range(10), i):
        num = "".join(list(map(str, list(j)[::-1])))
        results.append(int(num))

results.sort()
if n < len(results):
    print(results[n])
else:
    print(-1)