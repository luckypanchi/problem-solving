import sys

input = sys.stdin.readline


def cut(string):
    return string[:-1]


def flip(string):
    return string[::-1]


def solve(start, dest):
    if start == dest:
        return True

    if len(start) > 0:
        if start[-1] == "A" and solve(cut(start), dest):
            return True
        if start[0] == "B" and solve(cut(flip(start)), dest):
            return True
    return False


def main():
    dest = input().strip()
    start = input().strip()

    print(1 if solve(start, dest) else 0)


main()
