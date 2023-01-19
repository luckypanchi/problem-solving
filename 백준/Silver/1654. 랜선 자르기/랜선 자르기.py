import sys

input = sys.stdin.readline


def check(arr, length, pivot):
    cnt = 0
    for lan in arr:
        cnt += lan // length
    return pivot <= cnt


def main():
    k, n = map(int, input().split())
    lans = [int(input()) for _ in range(k)]

    min_length = 1
    max_length = max(lans)

    l = min_length
    r = max_length
    answer = 0

    while l <= r:
        mid = (l + r) // 2
        if check(lans, mid, n):
            if answer < mid:
                answer = mid
            l = mid + 1
        else:
            r = mid - 1

    print(answer)


main()
