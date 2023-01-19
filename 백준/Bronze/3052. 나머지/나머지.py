import sys

input = sys.stdin.readline


results = set()

for _ in range(10):
    n = int(input())
    results.add(n % 42)

print(len(results))
