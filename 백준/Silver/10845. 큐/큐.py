import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
orders = [input().split() for _ in range(n)]

que = deque()

for order in orders:
    if order[0] == "push":
        que.append(int(order[1]))
    elif order[0] == "pop":
        if que:
            print(que.popleft())
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
