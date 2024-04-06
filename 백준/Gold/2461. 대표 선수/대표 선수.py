import sys
import heapq

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
students = [list(map(int, input().split())) for _ in range(n)]

h = []
_min = INF
_max = -INF
for i in range(n):
    students[i].sort()
    value = students[i][0]
    _min = min(_min, value)
    _max = max(_max, value)
    heapq.heappush(h, (value, i, 0))

answer = _max - _min

while h:
    prev, studentIndex, index = heapq.heappop(h)
    if index + 1 == m:
        break

    value = students[studentIndex][index + 1]
    heapq.heappush(h, (value, studentIndex, index + 1))

    _max = max(_max, value)
    _min = h[0][0]
    answer = min(answer, _max - _min)

print(answer)