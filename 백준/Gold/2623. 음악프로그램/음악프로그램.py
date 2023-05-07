import sys
from collections import deque, defaultdict

input = sys.stdin.readline


n, m = map(int, input().split())
graph = defaultdict(list)
in_degree = [0] * (n + 1)

for _ in range(m):
    tmp = list(map(int, input().split()))
    for i in range(1, len(tmp) - 1):
        graph[tmp[i]].append(tmp[i + 1])
        in_degree[tmp[i + 1]] += 1


que = deque()
visited = [False] * (n + 1)
answer = []


for i in range(1, n + 1):
    if in_degree[i] == 0:
        visited[i] = True
        que.append(i)


while que:
    v = que.popleft()
    answer.append(v)

    for node in graph[v]:
        if not visited[node]:
            in_degree[node] -= 1
            if in_degree[node] == 0:
                visited[node] = True
                que.append(node)


if len(answer) != n:
    print(0)
else:
    for ans in answer:
        print(ans)