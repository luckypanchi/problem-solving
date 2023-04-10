import sys

input = sys.stdin.readline


def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])

    return parents[x]


def union(x, y):
    x = find(x)
    y = find(y)

    if x < y:
        parents[y] = x

    else:
        parents[x] = y


def ccw(x1, y1, x2, y2, x3, y3):
    cp = x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3

    if cp < 0:
        return -1
    elif cp == 0:
        return 0
    else:
        return 1


def check(idx1, idx2):
    x1, y1, x2, y2 = lines[idx1]
    a1, b1, a2, b2 = lines[idx2]

    xy = ccw(x1, y1, x2, y2, a1, b1) * ccw(x1, y1, x2, y2, a2, b2)
    ab = ccw(a1, b1, a2, b2, x1, y1) * ccw(a1, b1, a2, b2, x2, y2)

    if xy == 0 and ab == 0:
        return (
            min(x1, x2) <= max(a1, a2)
            and min(a1, a2) <= max(x1, x2)
            and min(y1, y2) <= max(b1, b2)
            and min(b1, b2) <= max(y1, y2)
        )

    return xy <= 0 and ab <= 0


n = int(input())
lines = []
for _ in range(n):
    a, b, c, d = map(int, input().split())
    if a < c:
        lines.append((a, b, c, d))
    else:
        lines.append((c, d, a, b))

parents = list(range(n))

for idx1 in range(n):
    for idx2 in range(n):
        if idx1 != idx2 and check(idx1, idx2):
            union(idx1, idx2)

for i in range(n):
    find(i)

counts = [0] * n

for p in parents:
    counts[p] += 1


count_groups = len(set(parents))
max_size = max(counts)

print(count_groups)
print(max_size)