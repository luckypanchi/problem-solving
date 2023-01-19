import sys
from collections import defaultdict, deque

input = sys.stdin.readline

dy = (-2,)


n, t = map(int, input().split())
available = defaultdict(list)
for _ in range(n):
    x, y = map(int, input().split())
    available[x].append(y)

visited = defaultdict(list)

que = deque()
que.append((0, 0, 0))
while que:
    x, y, cnt = que.popleft()

    if y == t:
        print(cnt)
        sys.exit()

    for nx in range(x - 2, x + 3):
        for ny in range(y - 2, y + 3):
            if nx in available and ny in available[nx] and ny not in visited[nx]:
                visited[nx].append(ny)
                que.append((nx, ny, cnt + 1))

print(-1)
