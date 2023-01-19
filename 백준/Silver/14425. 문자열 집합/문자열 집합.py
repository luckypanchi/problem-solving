import sys
from collections import defaultdict

input = sys.stdin.readline


n, m = map(int, input().split())
saved = [input().strip() for _ in range(n)]
targets = defaultdict(int)
for _ in range(m):
    targets[input().strip()] += 1

answer = 0
for tgt in targets:
    if tgt in saved:
        answer += targets[tgt]

print(answer)
