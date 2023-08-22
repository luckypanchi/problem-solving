import sys
from collections import deque, defaultdict

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))


que = deque()
distances = [INF] * (n + 1)

distances[1] = 0
que.append((0, 1))

while que:
    curr_dist, curr = que.popleft()

    if distances[curr] < curr_dist:
        continue

    for _next, dist in graph[curr]:
        next_dist = curr_dist + dist
        if next_dist < distances[_next]:
            distances[_next] = next_dist
            que.append((next_dist, _next))


print(distances[n])
