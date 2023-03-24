import sys

input = sys.stdin.readline

INF = float("inf")


def find(a):
    if parents[a] != a:
        parents[a] = find(parents[a])

    return parents[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if a == b:
        return True

    if a < b:
        parents[b] = a
        roots[a].extend(roots[b])
        roots[b].clear()
    elif b < a:
        parents[a] = b
        roots[b].extend(roots[a])
        roots[a].clear()

    return False


def get_min_pay(root):
    _m = INF
    for node in roots[root]:
        _m = min(_m, pays[node])

    return _m


n, m, k = map(int, input().split())
pays = [0] + list(map(int, input().split()))

parents = list(range(n + 1))
roots = [[i] for i in range(n + 1)]
total = 0

for _ in range(m):
    a, b = map(int, input().split())
    union(a, b)

for i in range(1, n + 1):
    if len(roots[i]) != 0:
        total += get_min_pay(i)

if total <= k:
    print(total)
else:
    print("Oh no")