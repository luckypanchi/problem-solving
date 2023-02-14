import sys
from itertools import combinations
from collections import defaultdict, deque

input = sys.stdin.readline
INF = int(1e9)


def bfs(comb):
    start = comb[0]
    que = deque([start])
    visited = [start]
    result = 0

    while que:
        curr = que.popleft()
        result += pp[curr]
        for nxt in d[curr]:
            if nxt not in visited and nxt in comb:
                visited.append(nxt)
                que.append(nxt)

    return (result, len(visited))


n = int(input())
pp = list(map(int, input().split()))
d = defaultdict(list)
for i in range(n):
    tmp = list(map(int, input().split()))
    for j in tmp[1:]:
        d[i].append(j - 1)

answer = INF

for i in range(1, n):
    combs = list(combinations(range(n), i))
    for comb in combs:
        res1, v1 = bfs(comb)
        res2, v2 = bfs([i for i in range(n) if i not in comb])
        if v1 + v2 == n:
            answer = min(answer, abs(res1 - res2))


if answer == INF:
    print(-1)
else:
    print(answer)