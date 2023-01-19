import sys

input = sys.stdin.readline

available = [False] * (20 * 100000 + 10)
n = 0
numbers = list()


def func(idx, acc):
    if idx == n:
        available[acc] = True
        return

    func(idx + 1, acc + numbers[idx])
    func(idx + 1, acc)


def main():
    global n, numbers

    n = int(input())
    numbers = list(map(int, input().split()))

    func(0, 0)

    idx = 0
    while True:
        if not available[idx]:
            print(idx)
            return
        idx += 1


main()
