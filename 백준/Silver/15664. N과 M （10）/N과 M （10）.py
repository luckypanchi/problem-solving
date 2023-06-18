import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

answer = set()
selected = [0] * m


def comb(idx, start):
    if idx == m:
        answer.add(tuple(selected))
        return

    for i in range(start, n):
        selected[idx] = numbers[i]
        comb(idx + 1, i + 1)


comb(0, 0)

answer = sorted(list(answer))

for ans in answer:
    print(*ans)