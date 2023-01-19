import sys

input = sys.stdin.readline


def main():
    n = int(input())
    matrix = []

    for idx in range(n):
        age, name = input().split()
        matrix.append((int(age), name, idx))

    matrix.sort(key=lambda x: x[2])
    matrix.sort(key=lambda x: x[0])

    for info in matrix:
        print(info[0], info[1])


main()
