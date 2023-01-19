import sys

input = sys.stdin.readline


def main():
    t = int(input())

    def solve(a, b):
        if b % a == 0:
            print(b // a)
            return

        num = (b // a) + 1

        return solve(a * num - b, b * num)

    for _ in range(t):
        a, b = map(int, input().split())
        solve(a, b)


main()
