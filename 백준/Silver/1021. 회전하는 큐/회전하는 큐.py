import sys
from collections import deque

input = sys.stdin.readline


def find(target):
    for i in range(len(que)):
        if que[i] == target:
            return i


def push_left(length):
    for _ in range(length):
        que.append(que.popleft())


def push_right(length):
    for _ in range(length):
        que.appendleft(que.pop())


n, m = map(int, input().split())
targets = list(map(int, input().split()))

que = deque(list(range(1, n + 1)))
answer = 0

for target in targets:
    idx = find(target)
    if idx < len(que) - idx:
        answer += idx
        push_left(idx)
    else:
        answer += len(que) - idx
        push_right(len(que) - idx)

    que.popleft()


print(answer)