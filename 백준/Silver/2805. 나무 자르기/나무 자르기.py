import sys

input = sys.stdin.readline


def check(arr, length, pivot):
    total = 0
    for wood in arr:
        if wood > length:
            total += wood - length
    return pivot <= total


def main():
    n, m = map(int, input().split())
    woods = list(map(int, input().split()))

    min_length = 0
    max_length = max(woods)

    l = min_length
    r = max_length
    answer = 0

    while l <= r:
        mid = (l + r) // 2
        if check(woods, mid, m):
            if answer < mid:
                answer = mid
            l = mid + 1
        else:
            r = mid - 1

    print(answer)


main()
