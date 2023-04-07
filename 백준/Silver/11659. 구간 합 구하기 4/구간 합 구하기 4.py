import sys

input = sys.stdin.readline


def update(index, num):
    idx = index
    while idx <= n:
        tree[idx] += num
        idx += idx & -idx


def acc_sum(index):
    idx = index
    result = 0
    while 0 < idx:
        result += tree[idx]
        idx -= idx & -idx
    return result


def make_tree():
    for i in range(1, n + 1):
        update(i, arr[i])


n, m = map(int, input().split())
arr = [0] + list(map(int, input().split()))

tree = [0] * (n + 1)

make_tree()

for _ in range(m):
    a, b = map(int, input().split())
    print(acc_sum(b) - acc_sum(a - 1))