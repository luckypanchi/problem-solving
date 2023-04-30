import sys

input = sys.stdin.readline


def update(idx, num):
    while idx <= n:
        tree[idx] += num
        idx += idx & -idx


def acc_sum(idx):
    result = 0
    while 0 < idx:
        result += tree[idx]
        idx -= idx & -idx
    return result


def make_tree():
    for i in range(1, n + 1):
        update(i, numbers[i])


n, m, k = map(int, input().split())
numbers = [0] + [int(input()) for _ in range(n)]
tree = [0] * (n + 1)


make_tree()


for _ in range(m + k):
    a, b, c = map(int, input().split())
    if a == 1:
        update(b, c - numbers[b])
        numbers[b] = c
    elif a == 2:
        print(acc_sum(c) - acc_sum(b - 1))