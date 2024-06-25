import sys
from collections import defaultdict

input = sys.stdin.readline


def dfsUp(start):
    if len(parents[start]) == 0:
        return 0

    result = 0
    for p in parents[start]:
        if not visited[p]:
            visited[p] = True
            result += dfsUp(p) + 1

    return result


def dfsDown(start):
    if len(childs[start]) == 0:
        return 0

    result = 0
    for c in childs[start]:
        if not visited[c]:
            visited[c] = True
            result += dfsDown(c) + 1

    return result


n = int(input())
m = int(input())

parents = defaultdict(list)
childs = defaultdict(list)

for _ in range(m):
    a, b = map(int, input().split())
    parents[b].append(a)
    childs[a].append(b)

for start in range(1, n + 1):
    visited = [False] * (n + 1)
    answer = n - dfsUp(start) - dfsDown(start) - 1
    print(answer)