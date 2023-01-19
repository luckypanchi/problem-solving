import sys

input = sys.stdin.readline


def main():
    n = int(input())
    numbers = list(map(int, input().split()))
    numbers.sort()

    print(numbers[0] * numbers[-1])


main()
