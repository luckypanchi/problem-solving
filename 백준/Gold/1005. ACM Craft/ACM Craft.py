import sys
from collections import deque

input = sys.stdin.readline


def topological_sort(adj_nodes):
    que = deque()
    in_degree = [0] * (n + 1)
    visited = [False] * (n + 1)
    result = []
    dp = [0] * (n + 1)

    for i in range(1, n + 1):
        for j in adj_nodes[i]:
            in_degree[j] += 1

    for i in range(1, n + 1):
        if in_degree[i] == 0:
            que.append(i)
            visited[i] = True
            dp[i] = times[i]

    while que:
        node = que.popleft()
        result.append(node)
        for nxt in adj_nodes[node]:
            in_degree[nxt] -= 1
            dp[nxt] = max(dp[nxt], dp[node] + times[nxt])
            if in_degree[nxt] == 0 and not visited[nxt]:
                que.append(nxt)
                visited[nxt] = True

    return dp[target]


tc = int(input())

for _ in range(tc):
    n, k = map(int, input().split())
    times = [0] + list(map(int, input().split()))
    adj_nodes = [[] for _ in range(n + 1)]
    for _ in range(k):
        a, b = map(int, input().split())
        adj_nodes[a].append(b)
    target = int(input())
    answer = topological_sort(adj_nodes)

    print(answer)