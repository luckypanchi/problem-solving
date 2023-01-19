import sys

input = sys.stdin.readline


def main():
    s = int(input())

    n = 1
    while True:
        if n * (n + 1) <= 2 * s and 2 * s < (n + 1) * (n + 2):
            break
        n += 1

    print(n)


main()
