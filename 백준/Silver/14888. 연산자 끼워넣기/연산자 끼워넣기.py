import sys

input = sys.stdin.readline

INF = float("inf")


def calc(curr, op, prevResult):
    if op == 0:
        return prevResult + numbers[curr + 1]
    elif op == 1:
        return prevResult - numbers[curr + 1]
    elif op == 2:
        return prevResult * numbers[curr + 1]
    else:
        return int(prevResult / numbers[curr + 1])


def permutations(curr, prevResult):
    global min_answer, max_answer
    if curr == n - 1:
        max_answer = max(max_answer, prevResult)
        min_answer = min(min_answer, prevResult)
        return

    for i in range(4):
        if counts[i] == 0:
            continue

        counts[i] -= 1
        permutations(curr + 1, calc(curr, i, prevResult))
        counts[i] += 1


n = int(input())
numbers = list(map(int, input().split()))
counts = list(map(int, input().split()))

max_answer = -INF
min_answer = INF

permutations(0, numbers[0])


print(max_answer)
print(min_answer)