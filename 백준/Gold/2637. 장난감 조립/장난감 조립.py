import sys
from collections import defaultdict, deque

input = sys.stdin.readline


n = int(input())
m = int(input())

graph = defaultdict(list)

que = deque()
in_degree = [0] * (n + 1)
is_basic = [False] * (n + 1)
dp = [[0] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    x, y, k = map(int, input().split())
    graph[y].append((x, k))
    in_degree[x] += 1

for i in range(1, n + 1):
    if in_degree[i] == 0:
        is_basic[i] = True
        que.append(i)

while que:
    curr = que.popleft()

    for _next, cnt in graph[curr]:
        in_degree[_next] -= 1

        if is_basic[curr]:
            dp[_next][curr] += cnt
        else:
            for i in range(1, n + 1):
                dp[_next][i] += dp[curr][i] * cnt

        if in_degree[_next] == 0:
            que.append(_next)


for idx, value in enumerate(dp[n]):
    if 0 < value:
        print(idx, value)