import sys
from collections import deque

input = sys.stdin.readline


def func_d(num):
    return 2 * num % 10000


def func_s(num):
    return num - 1 if num else 9999


def func_l(num):
    return (num % 1000) * 10 + num // 1000


def func_r(num):
    return (num % 10) * 1000 + num // 10


def func():
    start, dest = map(int, input().split())
    visited = [False] * 10000

    que = deque()
    que.append((start, ""))

    while que:
        num, record = que.popleft()

        if visited[num]:
            continue

        visited[num] = True
        if num == dest:
            return record
        que.append((func_d(num), record + "D"))
        que.append((func_s(num), record + "S"))
        que.append((func_l(num), record + "L"))
        que.append((func_r(num), record + "R"))


def main():
    n = int(input())
    answers = []
    for _ in range(n):
        answers.append(func())

    for answer in answers:
        print(answer)


main()
