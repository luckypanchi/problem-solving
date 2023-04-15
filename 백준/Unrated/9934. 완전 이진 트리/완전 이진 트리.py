import sys

input = sys.stdin.readline


def dfs(nodes, depth):
    length = len(nodes)
    if length == 0:
        return

    idx = length // 2
    tree[depth].append(nodes[idx])

    dfs(nodes[:idx], depth + 1)
    dfs(nodes[idx+1:], depth + 1)


n = int(input())
tree = [[] for _ in range(n)]

nodes = list(map(int, input().split()))

dfs(nodes, 0)

for t in tree:
    print(*t)