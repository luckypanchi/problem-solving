import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(node):
    visited[node] = True
    cycle.append(node)
    nxt_node = students[node]

    if visited[nxt_node]:
        if nxt_node in cycle:
            answer.extend(cycle[cycle.index(nxt_node) :])
        return
    else:
        dfs(nxt_node)


tc = int(input())
for _ in range(tc):
    n = int(input())
    students = [0] + list(map(int, input().split()))
    visited = [False] * (n + 1)
    answer = []

    for i in range(1, n + 1):
        if not visited[i]:
            cycle = []
            dfs(i)

    print(n - len(answer))