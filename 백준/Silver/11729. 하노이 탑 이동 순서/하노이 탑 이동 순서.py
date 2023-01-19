import sys

input = sys.stdin.readline


def move(pile, start, dest):
    if pile == 0:
        return

    move(pile - 1, start, 6 - start - dest)
    print(f"{start} {dest}")
    move(pile - 1, 6 - start - dest, dest)


def main():
    n = int(input())

    print(2 ** n - 1)
    move(n, 1, 3)


main()
