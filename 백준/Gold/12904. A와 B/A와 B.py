import sys

input = sys.stdin.readline


def main():
    start = list(input().strip())
    dest = list(input().strip())

    while len(start) != len(dest):
        if dest[-1] == "A":
            del dest[-1]
        elif dest[-1] == "B":
            del dest[-1]
            dest = list(reversed(dest))

    if start == dest:
        print(1)
    else:
        print(0)


main()
