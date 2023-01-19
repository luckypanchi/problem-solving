import sys

input = sys.stdin.readline


def main():
    n = int(input())
    m = [500, 100, 50, 10, 5, 1]

    money = 1000 - n

    count = 0

    for i in m:
        count += money // i
        money %= i

    print(count)


main()
