import sys
from collections import defaultdict

input = sys.stdin.readline


n, m = map(int, input().split())
cities = list(map(int, input().split()))
prices = [0] + [list(map(int, input().split())) for _ in range(n - 1)]

visited_count = defaultdict(int)

for i in range(m - 1):
    _min = min(cities[i], cities[i + 1])
    _max = max(cities[i], cities[i + 1])
    for j in range(_min, _max):
        visited_count[j] += 1

answer = 0

for train, count in visited_count.items():
    a, b, c = prices[train]
    answer += min(a * count, b * count + c)

print(answer)