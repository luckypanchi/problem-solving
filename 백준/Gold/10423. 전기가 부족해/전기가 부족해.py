import sys

input = sys.stdin.readline


def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])

    return parents[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if a == b:
        return False

    if a in roots and b in roots:
        return False

    if a in roots and b not in roots:
        parents[b] = a
    elif a not in roots and b in roots:
        parents[a] = b
    elif a < b:
        parents[b] = a
    elif b < a:
        parents[a] = b

    return True


n, m, k = map(int, input().split())
parents = list(range(n + 1))
roots = set(map(int, input().split()))
edges = [list(map(int, input().split())) for _ in range(m)]
edges.sort(key=lambda x: x[2])

answer = 0
for u, v, w in edges:
    if union(u, v):
        answer += w

print(answer)