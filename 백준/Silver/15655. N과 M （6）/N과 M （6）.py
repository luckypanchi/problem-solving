import sys

input = sys.stdin.readline


def solve(prev, idx):
    if idx == m:
        print(*selected)
        return

    for i in range(prev + 1, n):
        if not isSelected[i]:
            isSelected[i] = True
            selected[idx] = numbers[i]
            solve(i, idx + 1)
            isSelected[i] = False


n, m = map(int, input().split())
numbers = sorted(list(map(int, input().split())))

isSelected = [False] * n
selected = [0] * m

solve(-1, 0)