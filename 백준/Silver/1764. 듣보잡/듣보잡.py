import sys
from collections import defaultdict

input = sys.stdin.readline


n, m = map(int, input().split())
names = defaultdict(int)


for _ in range(n):
    name = input().rstrip()
    names[name] += 1

for _ in range(m):
    name = input().rstrip()
    names[name] += 1

answer = []

for name, cnt in names.items():
    if cnt == 2:
        answer.append(name)

answer.sort()

print(len(answer))
for name in answer:
    print(name)
