import sys

input = sys.stdin.readline

INF = float("inf")


def calc():
    result = 0
    for i in range(n - 1):
        result += abs(selected[i] - selected[i + 1])
    return result


def permutation(curr):
    global answer
    if curr == n:
        answer = max(answer, calc())
        return

    for i in range(n):
        if not is_selected[i]:
            is_selected[i] = True
            selected[curr] = numbers[i]
            permutation(curr + 1)
            is_selected[i] = False


n = int(input())
numbers = list(map(int, input().split()))

selected = [0] * n
is_selected = [False] * n

answer = -INF

permutation(0)

print(answer)