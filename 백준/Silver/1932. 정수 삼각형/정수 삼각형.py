import sys

input = sys.stdin.readline


def main():
    n = int(input())
    steps = [list(map(int, input().split())) for _ in range(n)]

    for i in range(1, n):
        for j in range(len(steps[i])):
            if j == 0:
                steps[i][j] += steps[i - 1][0]
            elif j == len(steps[i]) - 1:
                steps[i][j] += steps[i - 1][j - 1]
            else:
                steps[i][j] += max(steps[i - 1][j - 1], steps[i - 1][j])

    print(max(steps[-1]))


main()
