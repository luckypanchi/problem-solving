import sys
from collections import defaultdict, deque

input = sys.stdin.readline


n, t = map(int, input().split())
graph = defaultdict(list)

for _ in range(n):
    x, y = map(int, input().split())
    graph[x].append(y)

visited = set()
que = deque()

que.append((0, 0, 0))
visited.add((0, 0))

answer = -1
while que:
    x, y, count = que.popleft()

    if y == t:
        answer = count
        break

    for dx in range(-2, 3):
        for dy in range(-2, 3):
            nx = x + dx
            ny = y + dy
            if (nx, ny) not in visited and nx in graph and ny in graph[nx]:
                visited.add((nx, ny))
                que.append((nx, ny, count + 1))

print(answer)