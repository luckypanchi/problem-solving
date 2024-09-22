import sys

input = sys.stdin.readline


def dfs(curr):
    global answer
    if curr == n:
        answer.add("".join(selected))
        return

    for i in range(n):
        if is_selected[i]:
            continue

        if 0 < curr and selected[curr - 1] == s[i]:
            continue

        is_selected[i] = True
        selected[curr] = s[i]
        dfs(curr + 1)
        is_selected[i] = False


s = list(input().strip())
n = len(s)
is_selected = [False] * n
selected = [0] * n

answer = set()

dfs(0)

print(len(answer))