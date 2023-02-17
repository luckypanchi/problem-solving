import sys

input = sys.stdin.readline


def find_root(child):
    if parents[child] != child:
        parents[child] = find_root(parents[child])

    return parents[child]


def check_root(c1, c2):
    r1 = find_root(c1)
    r2 = find_root(c2)

    return r1 == r2


def union_root(c1, c2):
    r1 = find_root(c1)
    r2 = find_root(c2)

    if r1 != r2:
        parents[r2] = r1


n, m = map(int, input().split())
parents = list(range(n + 1))

for _ in range(m):
    op, a, b = map(int, input().split())
    if op == 0:
        union_root(a, b)
    else:
        if check_root(a, b):
            print("YES")
        else:
            print("NO")