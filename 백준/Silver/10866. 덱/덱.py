import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
orders = [input().split() for _ in range(n)]

que = deque()

for order in orders:
    if order[0] == "push_front":
        que.appendleft(int(order[1]))
    elif order[0] == "push_back":
        que.append(int(order[1]))
    elif order[0] == "pop_front":
        if que:
            print(que.popleft())
        else:
            print("-1")
    elif order[0] == "pop_back":
        if que:
            print(que.pop())
        else:
            print("-1")
    elif order[0] == "size":
        print(len(que))
    elif order[0] == "empty":
        if que:
            print("0")
        else:
            print("1")
    elif order[0] == "front":
        if que:
            print(que[0])
        else:
            print("-1")
    elif order[0] == "back":
        if que:
            print(que[-1])
        else:
            print("-1")
