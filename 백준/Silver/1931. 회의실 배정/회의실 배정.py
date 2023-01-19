import sys

input = sys.stdin.readline


def main():
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    matrix.sort(key=lambda x: x[0])
    matrix.sort(key=lambda x: x[1])

    cnt = 0
    end = 0

    for time in matrix:
        if end <= time[0]:
            end = time[1]
            cnt += 1

    print(cnt)


main()
