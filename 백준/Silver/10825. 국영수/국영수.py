import sys

input = sys.stdin.readline


def main():
    n = int(input())
    matrix = []

    for _ in range(n):
        name, *score = input().split()
        kor, eng, mth = map(int, score)

        matrix.append((name, kor, eng, mth))

    matrix.sort(key=lambda x: x[0])
    matrix.sort(key=lambda x: x[3], reverse=True)
    matrix.sort(key=lambda x: x[2])
    matrix.sort(key=lambda x: x[1], reverse=True)

    for info in matrix:
        print(info[0])


main()
