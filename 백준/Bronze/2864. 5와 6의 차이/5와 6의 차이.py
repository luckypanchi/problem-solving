import sys

input = sys.stdin.readline


def main():
    a, b = input().split()

    answer = []

    answer.append(int(a.replace("6", "5")) + int(b.replace("6", "5")))
    answer.append(int(a.replace("5", "6")) + int(b.replace("5", "6")))

    print(*answer)


main()
