import sys
from collections import defaultdict

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
        return False
    if a < b:
        parents[b] = a
        roots[a].extend(roots[b])
        roots[b].clear()
    elif b < a:
        parents[a] = b
        roots[b].extend(roots[a])
        roots[a].clear()
    return True


parents = list(range(LEN + 1))
roots = [[i] for i in range(LEN + 1)]


n = int(input())
for _ in range(n):
    tmp = input().strip().split()
    if tmp[0] == "I":
        a, b = map(int, tmp[1:])
        union(a, b)
    elif tmp[0] == "Q":
        a = int(tmp[1])
        p = find(a)
        print(len(roots[p]))