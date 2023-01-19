import sys

input = sys.stdin.readline


def lower_bound(arr, length, num):
    left = 0
    right = length
    while left < right:
        mid = (left + right) // 2
        if num <= arr[mid]:
            right = mid
        else:
            left = mid + 1
    return left


def main():
    n = int(input())
    array = list(map(int, input().split()))

    trace = [0] * n
    length = 0

    for num in array:
        idx = lower_bound(trace, length, num)
        trace[idx] = num
        if length == idx:
            length += 1

    print(length)


main()
