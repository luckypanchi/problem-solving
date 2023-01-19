import sys
from collections import deque

input = sys.stdin.readline


n, m = map(int, input().split())
bridges = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    bridges[a].append((b, c))
    bridges[b].append((a, c))
fac1, fac2 = map(int, input().split())


def check(weight):
    visited = [0] * (n + 1)
    visited[fac1] = 1
    que = deque()
    que.append(fac1)

    while que:
        p1 = que.popleft()
        if p1 == fac2:
            return True
        for p2, w in bridges[p1]:
            if visited[p2] == 0 and weight <= w:
                visited[p2] = 1
                que.append(p2)
    return False


start, end = 0, 1000000000
while start <= end:
    mid = (start + end) // 2
    if check(mid):
        start = mid + 1
    else:
        end = mid - 1

print(start - 1)
