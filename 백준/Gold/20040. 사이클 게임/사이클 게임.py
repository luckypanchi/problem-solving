import sys

input = sys.stdin.readline


def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])

    return parents[x]


def union(x, y):
    x = find(x)
    y = find(y)

    if x == y:
        return False

    if x < y:
        parents[y] = x
    elif y < x:
        parents[x] = y

    return True


n, m = map(int, input().split())
parents = list(range(n))


for t in range(1, m + 1):
    a, b = map(int, input().split())

    flag = union(a, b)

    if not flag:
        print(t)
        sys.exit()

print(0)