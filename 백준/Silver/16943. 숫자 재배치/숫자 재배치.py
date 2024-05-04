import sys

input = sys.stdin.readline


def solve(curr, prev):
    global answer
    if curr == len(a):
        if int(prev) < b:
            answer = max(answer, int(prev))
        return

    for i in range(len(a)):
        if not isSelected[i]:
            if curr == 0 and a[i] == "0":
                continue

            isSelected[i] = True
            solve(curr + 1, prev + a[i])
            isSelected[i] = False


a, b = map(int, input().split())
a = list(str(a).strip())

isSelected = [False] * len(a)
answer = -1

solve(0, "")

print(answer)