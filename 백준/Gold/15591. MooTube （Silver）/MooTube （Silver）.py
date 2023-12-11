import sys
from collections import defaultdict, deque

input = sys.stdin.readline
INF = float("inf")


def getCount(k, start):
    que = deque()
    visited = [False] * n

    que.append((start, INF))
    visited[start] = True

    result = 0

    while que:
        currNode, currUsado = que.popleft()

        for nextNode, usado in graph[currNode]:
            nextUsado = min(currUsado, usado)
            if visited[nextNode] or nextUsado < k:
                continue

            visited[nextNode] = True
            que.append((nextNode, nextUsado))
            result += 1

    return result


n, q = map(int, input().split())
graph = defaultdict(list)

for _ in range(n - 1):
    a, b, c = map(int, input().split())
    a -= 1
    b -= 1
    graph[a].append((b, c))
    graph[b].append((a, c))


for _ in range(q):
    k, v = map(int, input().split())
    print(getCount(k, v - 1))