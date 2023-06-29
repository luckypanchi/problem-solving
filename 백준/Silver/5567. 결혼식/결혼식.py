import sys
from collections import defaultdict, deque

input = sys.stdin.readline


n = int(input())
m = int(input())

visited = [False] * (n + 1)
graph = defaultdict(list)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

que = deque()
answer = 0

for node in graph[1]:
    visited[node] = True
    que.append(node)
    answer += 1

for node in que:
    for next_node in graph[node]:
        if not visited[next_node]:
            visited[next_node] = True
            answer += 1

if visited[1]:
    answer -= 1

print(answer)