import sys

input = sys.stdin.readline


def main():
    n = int(input())

    results = [1, 2]

    for i in range(2, n + 1):
        results.append(results[i - 1] + results[i - 2])

    print(results[n - 1] % 10007)


main()
