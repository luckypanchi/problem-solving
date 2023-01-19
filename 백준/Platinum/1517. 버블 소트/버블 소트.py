import sys

input = sys.stdin.readline

answer = 0


def merge_sorted(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]

        l = merge_sorted(left)
        r = merge_sorted(right)
        return merge(l, r)
    else:
        return arr


def merge(left, right):
    global answer
    i, j = 0, 0
    arr = []

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            arr.append(left[i])
            i += 1
        else:
            answer += len(left) - i
            arr.append(right[j])
            j += 1

    while i < len(left):
        arr.append(left[i])
        i += 1

    while j < len(right):
        arr.append(right[j])
        j += 1

    return arr


def main():
    n = int(input())
    numbers = list(map(int, input().split()))

    merge_sorted(numbers)

    print(answer)


main()
