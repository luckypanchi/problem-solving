import sys

input = sys.stdin.readline


n = int(input())
t, p = [0], [0]
for _ in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)

d = [0] * (n + 2)

for i in range(1, n + 1):
    if d[i] < d[i - 1]:
        d[i] = d[i - 1]
    if i + t[i] < n + 2:
        d[i + t[i]] = max(d[i + t[i]], d[i] + p[i])

print(max(d))
