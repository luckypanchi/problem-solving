import sys

input = sys.stdin.readline


array = list(input().strip())

results = []

for i in range(len(array)):
    results.append("".join(array[i:]))

results.sort()

for s in results:
    print(s)
