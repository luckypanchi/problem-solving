import sys

input = sys.stdin.readline


def main():
    n = int(input())
    numbers = [0] * 10001

    for _ in range(n):
        numbers[int(input())] += 1

    for idx in range(1, 10001):
        if numbers[idx] != 0:
            for _ in range(numbers[idx]):
                sys.stdout.write("%d\n" % idx)


main()
