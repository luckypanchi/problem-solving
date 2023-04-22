import sys
from collections import defaultdict, deque

input = sys.stdin.readline


def topological_sort():
    que = deque()

    array = []

    in_degree = [0] * (n + 1)
    for i in range(n):
        for nxt in subs[i]:
            in_degree[nxt] += 1

    for i in range(1, n + 1):
        if in_degree[i] == 0:
            que.append(i)

    while que:
        v = que.popleft()
        array.append(v)

        for nxt in subs[v]:
            in_degree[nxt] -= 1
            if in_degree[nxt] == 0:
                que.append(nxt)

    return array


n, m = map(int, input().split())
subs = defaultdict(list)
for _ in range(m):
    a, b = map(int, input().split())
    subs[a].append(b)

sorted_array = topological_sort()

answer = [1] * (n + 1)
for i in sorted_array:
    for nxt in subs[i]:
        answer[nxt] = max(answer[nxt], answer[i] + 1)

print(*answer[1:])