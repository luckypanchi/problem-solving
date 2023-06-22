import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = list(map(int, input().split()))


selected = [0] * m

answers = []


def perm(idx):
    if idx == m:
        answers.append(tuple(selected))
        return

    for i in range(n):
        selected[idx] = numbers[i]
        perm(idx + 1)


perm(0)

answers = sorted(list(set(answers)))

for ans in answers:
    print(*ans)