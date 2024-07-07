import sys

input = sys.stdin.readline


def find(x):
    if parents[x] == -1:
        return -1
    if parents[x] == x:
        return x

    return find(parents[x])


def union(x, y):
    x = find(x)
    y = find(y)

    if x == y and x != -1:
        parents[x] = -1
        parents[y] = -1
    elif x < y:
        parents[y] = x
    elif y < x:
        parents[x] = y


caseNumber = 0
while True:
    n, m = map(int, input().split())
    caseNumber += 1
    if (n, m) == (0, 0):
        break

    parents = list(range(n + 1))
    for _ in range(m):
        a, b = map(int, input().split())
        if a == b:
            parents[a] = -1
        else:
            union(a, b)

    for i in range(1, n + 1):
        parents[i] = find(i)

    treeCount = len(set(parents[1:])) - list(set(parents[1:])).count(-1)
    if treeCount == 0:
        print(f"Case {caseNumber}: No trees.")
    elif treeCount == 1:
        print(f"Case {caseNumber}: There is one tree.")
    else:
        print(f"Case {caseNumber}: A forest of {treeCount} trees.")
