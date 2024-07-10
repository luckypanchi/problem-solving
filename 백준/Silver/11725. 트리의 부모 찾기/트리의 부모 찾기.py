import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def dfs(curr, prev):
    parents[curr] = prev
    for nextNode in graph[curr]:
        if nextNode != prev:
            dfs(nextNode, curr)


n = int(input())
graph = defaultdict(list)
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

parents = [-1] * (n + 1)
dfs(1, 0)

print(*parents[2:], sep="\n")