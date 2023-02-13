import sys

input = sys.stdin.readline


def dfs(node, d):
    for nxt, nxt_d in nodes[node]:
        if visited[nxt] == -1:
            visited[nxt] = d + nxt_d
            dfs(nxt, d + nxt_d)


n = int(input())
nodes = [[] for _ in range(n + 1)]
for _ in range(n):
    tmp = list(map(int, input().split()))
    for i in range(1, len(tmp) - 2, 2):
        nodes[tmp[0]].append((tmp[i], tmp[i + 1]))


visited = [-1] * (n + 1)
visited[1] = 0
dfs(1, 0)

start = visited.index(max(visited))
visited = [-1] * (n + 1)
visited[start] = 0
dfs(start, 0)

print(max(visited))