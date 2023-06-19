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
    elif y < x:
        parents[x] = y


n, m = map(int, input().split())

parents = list(range(n + 1))

pre = list(map(int, input().split()))
if pre[0] != 0:
    for p in pre[1:]:
        union(p, 0)

groups = [list(map(int, input().split())) for _ in range(m)]

for i in range(m):
    cnt, *people = groups[i]

    if 1 < cnt:
        for j in range(cnt - 1):
            union(people[j], people[j + 1])

answer = 0

for i in range(m):
    cnt, *people = groups[i]

    if find(people[0]) != 0:
        answer += 1

print(answer)