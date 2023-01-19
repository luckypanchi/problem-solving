import sys
from collections import deque

input = sys.stdin.readline


n, k = map(int, input().split())
stones = list(map(int, input().split()))

visited = [False] * n

que = deque()
que.append(0)
visited[0] = True

while que:
    s = que.popleft()

    if s == n - 1:
        break

    for d in range(s + 1, min(n, s + k)):
        if not visited[d] and (d - s) * (1 + abs(stones[s] - stones[d])) <= k:
            visited[d] = True
            que.append(d)

print("YES" if visited[n - 1] else "NO")
