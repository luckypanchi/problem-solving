import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def dfs(curr):
    result = costs[curr]
    for nextNode in adjList[curr]:
        if not visited[nextNode]:
            visited[nextNode] = True
            result = min(result, dfs(nextNode))

    return result


n, m, k = map(int, input().split())
costs = [0] + list(map(int, input().split()))
adjList = defaultdict(set)
for _ in range(m):
    v, w = map(int, input().split())

    if v == w:
        continue

    adjList[v].add(w)
    adjList[w].add(v)

for f in adjList:
    adjList[f] = list(adjList[f])

visited = [False] * (n + 1)
answer = 0
for start in range(1, n + 1):
    if not visited[start]:
        visited[start] = True
        answer += dfs(start)

if k < answer:
    answer = "Oh no"

print(answer)