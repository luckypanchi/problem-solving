import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def dfs(curr, prev, c):
    result = 0

    if colors[curr] != c:
        result += 1
        c = colors[curr]

    for nextNode in graph[curr]:
        if nextNode == prev:
            continue

        result += dfs(nextNode, curr, c)

    return result


n = int(input())
colors = [-1] + list(map(int, input().split()))
graph = defaultdict(list)
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

answer = dfs(1, 0, 0)

print(answer)