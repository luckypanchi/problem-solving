import sys
from collections import defaultdict

sys.setrecursionlimit(10**6)

input = sys.stdin.readline


def dfs(node):
    if not node in d:
        return 0

    results = []

    for dest, cost in d[node]:
        results.append(cost + dfs(dest))

    if len(results) == 1:
        answers.append(results[0])
    else:
        results.sort(reverse=True)
        answers.append(results[0] + results[1])

    return results[0]

n = int(input())
if n == 1:
    print(0)
    sys.exit()

d = defaultdict(list)
for _ in range(n - 1):
    start, dest, cost = map(int, input().split())
    d[start].append((dest, cost))

answers = []

dfs(1)
print(max(answers))