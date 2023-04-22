import sys
from collections import defaultdict, deque

input = sys.stdin.readline


n = int(input())
times = [0] * (n + 1)
graph = defaultdict(list)

in_degree = [0] * (n + 1)

for i in range(1, n + 1):
    tmp = list(map(int, input().split()))
    times[i] = tmp[0]
    for idx in range(2, len(tmp)):
        graph[tmp[idx]].append(i)
        in_degree[i] += 1

que = deque()
answer = [0] * (n + 1)

for i in range(1, n + 1):
    if in_degree[i] == 0:
        answer[i] = times[i]
        que.append(i)

while que:
    v = que.popleft()

    for nxt in graph[v]:
        in_degree[nxt] -= 1
        answer[nxt] = max(answer[nxt], answer[v] + times[nxt])
        if in_degree[nxt] == 0:
            que.append(nxt)

print(max(answer))