import sys

input = sys.stdin.readline

results = set()


def func(arr, acc):
    if len(arr) == 2:
        results.add(acc)
        return

    for i in range(1, len(arr) - 1):
        temp = arr[i]
        temp_acc = arr[i - 1] * arr[i + 1]
        del arr[i]
        func(arr, acc + temp_acc)
        arr.insert(i, temp)


def main():
    length = int(input())
    numbers = list(map(int, input().split()))

    func(numbers, 0)
    list_results = list(results)
    print(max(list_results))


main()
