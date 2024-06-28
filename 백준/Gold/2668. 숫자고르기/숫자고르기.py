import sys

input = sys.stdin.readline


def dfs(curr, start):
    nextNode = array[curr]

    if not visited[nextNode]:
        visited[nextNode] = True
        dfs(nextNode, start)
    elif visited[nextNode] and nextNode == start:
        result.append(start)


n = int(input())
array = [0] + [int(input()) for _ in range(n)]

result = []
for start in range(1, n + 1):
    visited = [False] * (n + 1)
    visited[start] = True
    dfs(start, start)

result.sort()
print(len(result))
print(*result, sep="\n")