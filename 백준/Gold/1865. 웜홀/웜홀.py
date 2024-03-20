import sys

input = sys.stdin.readline

INF = 1e9


def bellmanFord(n, edges):
    distances = [0] * (n + 1)

    for cnt in range(n):
        for i in range(len(edges)):
            curr, _next, cost = edges[i]

            if distances[curr] + cost < distances[_next]:
                distances[_next] = distances[curr] + cost

                if cnt == n - 1:
                    return True

    return False


tc = int(input())
for _ in range(tc):
    n, m, w = map(int, input().split())
    edges = []
    for _ in range(m):
        s, e, t = map(int, input().split())
        edges.append((s, e, t))
        edges.append((e, s, t))
    for _ in range(w):
        s, e, t = map(int, input().split())
        edges.append((s, e, -t))

    if bellmanFord(n, edges):
        print("YES")
    else:
        print("NO")