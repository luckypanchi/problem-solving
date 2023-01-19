import sys

input = sys.stdin.readline


def main():
    n = int(input())
    rope = [int(input()) for _ in range(n)]

    rope.sort(reverse=True)
    max_w = -1

    for i, w in enumerate(rope):
        max_w = max(max_w, w * (i + 1))

    print(max_w)


main()
