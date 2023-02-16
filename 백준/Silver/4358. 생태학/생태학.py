import sys
from collections import defaultdict

input = sys.stdin.readline

record = defaultdict(int)
total = 0

while True:
    tree = input().strip()
    if tree == "":
        break

    total += 1
    record[tree] += 1

keys = list(record.keys())
keys.sort()

for tree in keys:
    print(f"{tree} {record[tree] / total * 100:.4f}")