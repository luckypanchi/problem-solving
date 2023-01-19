import sys

input = sys.stdin.readline


def main():
    results = [1, 2, 4]

    for i in range(3, 11):
        results.append(results[i - 1] + results[i - 2] + results[i - 3])

    tc = int(input())
    for _ in range(tc):
        n = int(input())
        print(results[n - 1])


main()
