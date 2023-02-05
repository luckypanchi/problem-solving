import sys

input = sys.stdin.readline


w, h, x, y, p = map(int, input().split())
r = h // 2


def check1(px, py):
    if x - r <= px <= x and y <= py <= y + h and (px - x) ** 2 + (py - y - r) ** 2 <= r ** 2:
        return True
    else:
        return False


def check2(px, py):
    if x <= px <= x + w and y <= py <= y + h:
        return True
    else:
        return False


def check3(px, py):
    if x + w <= px <= x + w + r and y <= py <= y + h and (px - x - w) ** 2 + (py - y - r) ** 2 <= r ** 2:
        return True
    else:
        return False


answer = 0
for _ in range(p):
    px, py = map(int, input().split())
    if check1(px, py) or check2(px, py) or check3(px, py):
        answer += 1


print(answer)