import sys

input = sys.stdin.readline


def partial(size, start, n, m, cnt):
    if size == 2:
        return start + m + 2 * n

    pivot = size // 2

    if n < pivot and m < pivot:
        return partial(size // 2, start, n, m, cnt + 1)
    elif n < pivot and m >= pivot:
        return partial(size // 2, start + (pivot ** 2), n, m - pivot, cnt + 1)
    elif n >= pivot and m < pivot:
        return partial(size // 2, start + (pivot ** 2) * 2, n - pivot, m, cnt + 1)
    else:
        return partial(
            size // 2, start + (pivot ** 2) * 3, n - pivot, m - pivot, cnt + 1
        )


def main():
    n, r, c = map(int, input().split())

    answer = partial(2 ** n, 0, r, c, 0)

    print(answer)


main()
