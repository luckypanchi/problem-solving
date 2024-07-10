import sys
from collections import defaultdict
import heapq

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def dfs(curr, prev):
    global answer

    if len(graph[curr]) == 0:
        return 0

    h = []
    for nextNode, w in graph[curr]:
        if nextNode == prev:
            continue

        heapq.heappush(h, -(w + dfs(nextNode, curr)))

    maxValue = -heapq.heappop(h)
    if len(h) == 0:
        answer = max(answer, maxValue)
    elif 0 < len(h):
        answer = max(answer, maxValue - heapq.heappop(h))

    return maxValue


n = int(input())
graph = defaultdict(list)
for _ in range(n - 1):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

answer = 0
dfs(1, 0)

print(answer)