import sys

input = sys.stdin.readline


def find_root(child):
    if parents[child] != child:
        parents[child] = find_root(parents[child])

    return parents[child]


def union(c1, c2):
    r1 = find_root(c1)
    r2 = find_root(c2)

    if r1 < r2:
        parents[r2] = r1
    else:
        parents[r1] = r2


n = int(input())
m = int(input())
parents = list(range(n + 1))
relations = [list(map(int, input().split())) for _ in range(n)]
for i in range(n):
    for j in range(n):
        if relations[i][j] == 1:
            union(i + 1, j + 1)


plan = list(map(int, input().split()))
root = parents[plan[0]]
for i in range(1, m):
    if root != parents[plan[i]]:
        print("NO")
        sys.exit()

print("YES")