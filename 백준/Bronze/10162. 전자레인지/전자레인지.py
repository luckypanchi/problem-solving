import sys

input = sys.stdin.readline


def main():
    n = int(input())
    m = [300, 60, 10]

    counts = []

    for t in m:
        counts.append(n // t)
        n %= t

    if n == 0:
        print(*counts)
    else:
        print(-1)


main()
