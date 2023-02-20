import sys

input = sys.stdin.readline


m = int(input())
flag = 0

answer = []
for _ in range(m):
    tmp = list(input().split())
    if tmp[0] == "add":
        flag |= 1 << int(tmp[1])

    elif tmp[0] == "remove":
        flag &= ~(1 << int(tmp[1]))

    elif tmp[0] == "check":
        if flag & (1 << int(tmp[1])):
            print(1)
        else:
            print(0)

    elif tmp[0] == "toggle":
        flag ^= 1 << int(tmp[1])

    elif tmp[0] == "all":
        flag = (1 << 21) - 1

    elif tmp[0] == "empty":
        flag = 0