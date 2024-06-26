import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

input = sys.stdin.readline

INF = float("inf")


def dfs(curr, totalCost, maxCost):
    if curr == dest:
        return totalCost - maxCost

    result = INF
    for nextNode, cost in adjList[curr]:
        if not visited[nextNode]:
            visited[nextNode] = True
            result = min(result, dfs(nextNode, totalCost + cost, max(maxCost, cost)))

    return result


n, start, dest = map(int, input().split())
adjList = defaultdict(list)
for _ in range(n - 1):
    a, b, cost = map(int, input().split())
    adjList[a].append((b, cost))
    adjList[b].append((a, cost))

visited = [False] * (n + 1)
visited[start] = True
answer = dfs(start, 0, 0)

print(answer)