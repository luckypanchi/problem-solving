import sys

input = sys.stdin.readline


def main():
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    a.sort()
    b.sort()

    answer = 0

    for i in range(n):
        answer += a[i] * b[n - 1 - i]

    print(answer)


main()
