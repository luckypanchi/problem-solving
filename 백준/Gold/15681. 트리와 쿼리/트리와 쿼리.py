import sys
from collections import defaultdict

sys.setrecursionlimit(10**6)

input = sys.stdin.readline


def set_depth(parent, d):
    depth[parent] = d

    for child in graph[parent]:
        if depth[child] == -1:
            set_depth(child, d + 1)


def get_subtree_size(root):
    if size[root] != 0:
        return

    size[root] = 1

    for child in graph[root]:
        if depth[root] < depth[child]:
            get_subtree_size(child)
            size[root] += size[child]


n, r, q = map(int, input().split())

graph = defaultdict(list)
depth = [-1] * (n + 1)
size = [0] * (n + 1)

for _ in range(n - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)


set_depth(r, 0)

for _ in range(q):
    root = int(input())
    get_subtree_size(root)
    print(size[root])