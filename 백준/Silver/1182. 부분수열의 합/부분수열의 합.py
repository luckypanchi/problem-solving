import sys

input = sys.stdin.readline


def solve(curr, prevSum):
    if curr == n:
        return prevSum == s

    result = 0
    result += solve(curr + 1, prevSum + numbers[curr])
    result += solve(curr + 1, prevSum)

    return result


n, s = map(int, input().split())
numbers = list(map(int, input().split()))

answer = solve(0, 0)

if s == 0:
    answer -= 1

print(answer)