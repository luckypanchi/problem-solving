import sys
from collections import deque

input = sys.stdin.readline


def main():
    k = int(input())
    stack = deque()
    for _ in range(k):
        n = int(input())
        if n == 0:
            stack.pop()
        else:
            stack.append(n)

    print(sum(stack))


main()
