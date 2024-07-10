import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def dfs(curr, prev):
    for nextNode in graph[curr]:
        if nextNode == prev:
            continue

        dfs(nextNode, curr)
        subtreeSize[curr] += subtreeSize[nextNode]


n, r, q = map(int, input().split())
graph = defaultdict(list)
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

subtreeSize = [1] * (n + 1)
dfs(r, 0)

for _ in range(q):
    u = int(input())
    print(subtreeSize[u])