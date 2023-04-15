import sys
from collections import defaultdict, deque

input = sys.stdin.readline

INF = int(1e9)

n, m = map(int, input().split())
graph = defaultdict(list)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

depth = [0] * (n + 1)

que = deque()
depth[1] = 1
que.append(1)

while que:
    curr = que.popleft()

    for nxt in graph[curr]:
        if depth[nxt] == 0:
            depth[nxt] += depth[curr] + 1
            que.append(nxt)

nodes = []
_max = -INF

for node, d in enumerate(depth):
    if d == _max:
        nodes.append(node)
    elif _max < d:
        _max = d
        nodes = [node]

_max -= 1

print(min(nodes), _max, len(nodes))