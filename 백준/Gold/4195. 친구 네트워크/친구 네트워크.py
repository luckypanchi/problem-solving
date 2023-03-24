import sys

input = sys.stdin.readline

LEN = int(1e6)


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


tc = int(input())

for _ in range(tc):
    parents = list(range(LEN + 1))
    roots = [[i] for i in range(LEN + 1)]

    name = dict()
    idx = 1
    n = int(input())
    for _ in range(n):
        a, b = input().split()
        for node in [a, b]:
            if node not in name:
                name[node] = idx
                idx += 1

        a = name[a]
        b = name[b]

        union(a, b)
        p = find(a)
        print(len(roots[p]))