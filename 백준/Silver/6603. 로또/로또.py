import sys
from itertools import combinations

input = sys.stdin.readline


def main():
    while True:
        arr = list(map(int, input().split()))
        n = arr[0]
        arr = arr[1:]

        if n == 0:
            break

        for i in list(combinations(arr, 6)):
            print(*i)
        print()


main()
