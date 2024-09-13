import sys

input = sys.stdin.readline


def solve(n):
    curr = 1
    while True:
        if curr % n == 0:
            return len(str(curr))
        curr = 10 * curr + 1


while True:
    try:
        n = int(input())
        print(solve(n))
    except:
        break