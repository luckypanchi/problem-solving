import sys

input = sys.stdin.readline


def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])

    return parents[x]


def union(x, y):
    x = find(x)
    y = find(y)

    if y < x:
        parents[y] = x
    elif x < y:
        parents[x] = y


def upper_bound(x):
    left = 0
    right = m
    while left < right:
        mid = (left + right) // 2
        if x < cards[mid]:
            right = mid
        else:
            left = mid + 1

    return right


n, m, k = map(int, input().split())
cards = sorted(list(map(int, input().split())))
chulsu = list(map(int, input().split()))

parents = list(range(n))


for card in chulsu:
    idx = find(upper_bound(card))
    print(cards[idx])

    if idx + 1 < m:
        union(idx, idx + 1)
