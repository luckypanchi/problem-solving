import sys

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
dist = [[INF] * (n + 1) for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    dist[a][b] = 1
    dist[b][a] = 1

for i in range(1, n + 1):
    dist[i][i] = 0

for mid in range(1, n + 1):
    for start in range(1, n + 1):
        for end in range(1, n + 1):
            dist[start][end] = min(dist[start][end], dist[start][mid] + dist[mid][end])

results = [0] * (n + 1)
for start in range(1, n + 1):
    for end in range(1, n + 1):
        results[start] += dist[start][end]

m = min(results[1:])
print(results.index(m))