import sys
from collections import defaultdict, deque

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())

graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

start = 1

que = deque()
distances = [INF] * (n + 1)

distances[start] = 0
que.append((distances[start], start))

while que:
    curr_dist, curr = que.popleft()

    if distances[curr] < curr_dist:
        continue

    for next_dest, dist in graph[curr]:
        next_dist = curr_dist + dist
        if next_dist < distances[next_dest]:
            distances[next_dest] = next_dist
            que.append((next_dist, next_dest))


results = []
tmp_distances = [INF] * (n + 1)

tmp_distances[start] = 0
que.append((tmp_distances[start], start))

while que:
    curr_dist, curr = que.popleft()

    if tmp_distances[curr] < curr_dist:
        continue

    for next_dest, dist in graph[curr]:
        next_dist = curr_dist + dist
        if next_dist < tmp_distances[next_dest]:
            tmp_distances[next_dest] = next_dist
            que.append((next_dist, next_dest))

            if tmp_distances[next_dest] == distances[next_dest]:
                results.append((curr, next_dest))


print(len(results))
for res in results:
    print(*res)