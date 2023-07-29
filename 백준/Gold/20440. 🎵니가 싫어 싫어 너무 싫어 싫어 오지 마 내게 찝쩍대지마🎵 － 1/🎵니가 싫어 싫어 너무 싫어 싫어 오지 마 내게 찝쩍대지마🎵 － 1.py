import sys
from collections import defaultdict

input = sys.stdin.readline


n = int(input())

timeline = defaultdict(int)
for _ in range(n):
    s, e = map(int, input().split())
    timeline[s] += 1
    timeline[e] -= 1


_max, cnt = 0, 0
start, end = 0, 0
is_max = False
for i in sorted(timeline.keys()):
    cnt += timeline[i]
    if _max < cnt:
        _max = cnt
        start = i
        is_max = True
    elif cnt < _max and is_max:
        end = i
        is_max = False

print(_max)
print(start, end)