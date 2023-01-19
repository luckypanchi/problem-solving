import sys

input = sys.stdin.readline


def main():
    n = int(input())
    alphabets = {}

    for _ in range(n):
        arr = input().strip()
        num = 1
        for letter in arr[::-1]:
            if letter not in alphabets:
                alphabets[letter] = 0
            alphabets[letter] += num
            num *= 10

    total = 0
    ordered = sorted(alphabets.values(), reverse=True)
    for idx in range(len(ordered)):
        total += (9 - idx) * ordered[idx]

    print(total)


main()
