import sys
from collections import defaultdict

input = sys.stdin.readline


s = 0
d = defaultdict(int)
for _ in range(10):
    n = int(input())
    d[n] += 1
    s += n

ans2 = 0
m = 0
for num, c in d.items():
    if m < c:
        m = c
        ans2 = num

print(s // 10)
print(ans2)