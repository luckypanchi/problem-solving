import sys

INF = float("inf")
input = sys.stdin.readline


operators = ["+", "-", "*", "//"]


def dfs(expression, depth):
    global maxValue, minValue

    if depth == n:
        result = eval(expression)
        maxValue = max(maxValue, result)
        minValue = min(minValue, result)
        return

    for i in range(4):
        if 0 < counter[i]:
            counter[i] -= 1

            number = str(numbers[depth])
            dfs(expression + operators[i] + number, depth + 1)

            counter[i] += 1


n = int(input())
numbers = list(map(int, input().split()))
counter = list(map(int, input().split()))

maxValue = -INF
minValue = INF

dfs(str(numbers[0]), 1)

print(maxValue)
print(minValue)