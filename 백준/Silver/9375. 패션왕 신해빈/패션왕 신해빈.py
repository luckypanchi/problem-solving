import sys
from collections import defaultdict

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    n = int(input())
    counts = defaultdict(int)
    for _ in range(n):
        _, c = input().split()
        counts[c] += 1
    for c in counts:
        counts[c] += 1

    answer = 1
    for c in counts:
        answer *= counts[c]

    print(answer - 1)