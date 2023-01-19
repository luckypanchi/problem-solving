import sys

input = sys.stdin.readline


def main():
    n = int(input())

    numbers = []

    for _ in range(n):
        numbers.append(int(input()))

    numbers.sort()

    for num in numbers:
        print(num)


main()
