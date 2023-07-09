import sys

input = sys.stdin.readline


def check(number):
    if number == 1:
        return False

    for num in range(2, int(number**0.5) + 1):
        if number % num == 0:
            return False

    return True


def dfs(prev, cnt):
    if cnt == n:
        answers.append(prev)
        return

    for m in range(1, 10):
        new_number = 10 * prev + m
        if check(new_number):
            dfs(new_number, cnt + 1)


n = int(input())

answers = []

dfs(0, 0)

for ans in answers:
    print(ans)