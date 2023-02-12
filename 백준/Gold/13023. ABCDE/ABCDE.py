import sys

input = sys.stdin.readline


def dfs(node, cnt):
    if cnt == 4:
        print(1)
        sys.exit()

    for nxt in persons[node]:
        if not visited[nxt]:
            visited[nxt] = True
            dfs(nxt, cnt + 1)
            visited[nxt] = False

n, m = map(int, input().split())
persons = [[] for _ in range(n)]
visited = [False] * n

for _ in range(m):
    a, b = map(int, input().split())
    persons[a].append(b)
    persons[b].append(a)

for i in range(n):
    visited[i] = True
    dfs(i, 0)
    visited[i] = False

print(0)