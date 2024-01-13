import sys

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    w1, w2 = 0, 0
    for _ in range(9):
        y, k = map(int, input().split())
        w1 += y
        w2 += k

    if w1 < w2:
        print("Korea")
    elif w1 > w2:
        print("Yonsei")
    else:
        print("Draw")