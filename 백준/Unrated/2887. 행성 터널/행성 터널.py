import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline


def prim():
    visited = [False] * n
    visited[0] = True
    heap = relation[0]
    heapq.heapify(heap)

    answer = 0

    while heap:
        cost, dest = heapq.heappop(heap)

        if not visited[dest]:
            visited[dest] = True
            answer += cost
            for edge in relation[dest]:
                if not visited[edge[1]]:
                    heapq.heappush(heap, edge)

    return answer


n = int(input())
planets = []
for i in range(n):
    x, y, z = map(int, input().split())
    planets.append((x, y, z, i))
relation = defaultdict(list)

for k in range(3):
    planets.sort(key=lambda x: x[k])
    for i in range(n - 1):
        curr_planet = planets[i]
        next_planet = planets[i + 1]
        d = abs(curr_planet[k] - next_planet[k])
        relation[curr_planet[3]].append((d, next_planet[3]))
        relation[next_planet[3]].append((d, curr_planet[3]))

answer = prim()

print(answer)
