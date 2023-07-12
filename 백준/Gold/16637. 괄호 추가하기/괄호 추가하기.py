import sys

input = sys.stdin.readline

INF = float("inf")


def operate(n1, op, n2):
    if op == "+":
        return int(n1) + int(n2)
    elif op == "-":
        return int(n1) - int(n2)
    elif op == "*":
        return int(n1) * int(n2)


def dfs(idx, prev):
    global answer

    if n <= idx:
        answer = max(answer, prev)
        return

    if idx + 3 < n:
        pre = operate(array[idx + 1], array[idx + 2], array[idx + 3])
        dfs(idx + 4, operate(prev, array[idx], pre))
    dfs(idx + 2, operate(prev, array[idx], array[idx + 1]))


n = int(input())
array = list(input().strip())

answer = -INF

if n == 1:
    answer = array[0]
else:
    dfs(1, array[0])

print(answer)