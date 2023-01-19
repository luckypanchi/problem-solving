import sys
from collections import deque

input = sys.stdin.readline


n, m = map(int, input().split())
in_degree = [0] * (n + 1)
nodes = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    in_degree[b] += 1
    nodes[a].append(b)

que = deque()

for i in range(1, n + 1):
    if in_degree[i] == 0:
        que.append(i)

while que:
    curr = que.popleft()
    print(curr, end=" ")
    for node in nodes[curr]:
        in_degree[node] -= 1
        if in_degree[node] == 0:
            que.append(node)
