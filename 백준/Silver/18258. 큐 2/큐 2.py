import sys
from collections import deque

input = sys.stdin.readline


n = int(input())
que = deque()

for _ in range(n):
    string = list(input().split())

    if string[0] == "push":
        que.append(int(string[1]))

    elif string[0] == "pop":
        if len(que) == 0:
            print(-1)
        else:
            print(que.popleft())

    elif string[0] == "size":
        print(len(que))

    elif string[0] == "empty":
        if len(que) == 0:
            print(1)
        else:
            print(0)

    elif string[0] == "front":
        if len(que) == 0:
            print(-1)
        else:
            print(que[0])

    elif string[0] == "back":
        if len(que) == 0:
            print(-1)
        else:
            print(que[-1])