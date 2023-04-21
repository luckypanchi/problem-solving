import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = sorted(list(map(int, input().split())))

is_selected = [False] * n
selected = [0] * m


def perm(cnt):
    if cnt == m:
        print(*selected)
        return

    for i in range(n):
        if not is_selected[i]:
            is_selected[i] = True
            selected[cnt] = numbers[i]
            perm(cnt + 1)
            is_selected[i] = False


perm(0)