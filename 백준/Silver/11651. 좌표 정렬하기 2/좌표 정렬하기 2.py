import sys

input = sys.stdin.readline


def main():
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    matrix.sort(key=lambda x: x[0])
    matrix.sort(key=lambda x: x[1])

    for p in matrix:
        print(*p)


main()
