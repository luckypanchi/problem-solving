import sys

input = sys.stdin.readline


def solve(curr, prev):
    if curr == k:
        results.add(prev)
        return

    for i in range(n):
        if not isSelected[i]:
            isSelected[i] = True
            solve(curr + 1, prev + str(numbers[i]))
            isSelected[i] = False


n = int(input())
k = int(input())
numbers = [int(input()) for _ in range(n)]

isSelected = [False] * n
results = set()

solve(0, "")

print(len(results))