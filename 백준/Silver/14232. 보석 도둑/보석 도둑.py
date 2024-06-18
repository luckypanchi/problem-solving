import sys

input = sys.stdin.readline


k = int(input())

results = []

for i in range(2, int(k**0.5) + 1):
    while k % i == 0:
        results.append(i)
        k //= i

if k != 1:
    results.append(k)

results.sort()

print(len(results))
print(*results)