import sys
import heapq
from collections import defaultdict, deque


input = sys.stdin.readline

INF = float("inf")


def dijkstra():
    dist = [INF] * n
    heap = []
    dist[s] = 0
    heapq.heappush(heap, (0, s))

    prev = defaultdict(list)

    while heap:
        curr_dist, curr_dest = heapq.heappop(heap)

        if dist[curr_dest] < curr_dist:
            continue

        for next_dist, next_dest in graph[curr_dest]:
            total_dist = curr_dist + next_dist
            if total_dist < dist[next_dest]:
                dist[next_dest] = total_dist
                heapq.heappush(heap, (total_dist, next_dest))
                prev[next_dest] = [curr_dest]
            elif total_dist == dist[next_dest]:
                prev[next_dest].append(curr_dest)

    return prev


def dijkstra2(denied):
    dist = [INF] * n
    heap = []
    dist[s] = 0
    heapq.heappush(heap, (0, s))

    while heap:
        curr_dist, curr_dest = heapq.heappop(heap)

        if dist[curr_dest] < curr_dist:
            continue

        for next_dist, next_dest in graph[curr_dest]:
            if not denied[curr_dest][next_dest]:
                total_dist = curr_dist + next_dist
                if total_dist < dist[next_dest]:
                    dist[next_dest] = total_dist
                    heapq.heappush(heap, (total_dist, next_dest))

    return dist[d] if dist[d] != INF else -1


def get_denied(curr, prev, denied):
    if curr == s:
        return

    for p in prev[curr]:
        if not denied[p][curr]:
            denied[p][curr] = True
            get_denied(p, prev, denied)


answers = []

while True:
    n, m = map(int, input().split())

    if n == 0 and m == 0:
        break

    s, d = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(m):
        u, v, p = map(int, input().split())
        graph[u].append((p, v))

    prev = dijkstra()

    denied = [[False] * n for _ in range(n)]
    get_denied(d, prev, denied)

    print(dijkstra2(denied))