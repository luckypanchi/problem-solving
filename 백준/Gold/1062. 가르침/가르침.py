import sys
from itertools import combinations

input = sys.stdin.readline


def main():
    n, k = map(int, input().split())
    words = list(input().strip() for _ in range(n))

    known_words = ["a", "n", "t", "i", "c"]
    unknown_words = set()

    if k < len(known_words):
        print(0)
        return
    else:
        for word in words:
            for letter in word[4:-4]:
                if letter not in known_words:
                    unknown_words.add(letter)

    if len(unknown_words) < k - 5:
        print(n)
        return

    answer = []

    for tmp in list(combinations(unknown_words, k - 5)):
        for item in tmp:
            known_words.append(item)

        know = True
        result = 0

        for word in words:
            for letter in word[4:-4]:
                if letter not in known_words:
                    know = False
            if know:
                result += 1
            know = True

        answer.append(result)

        for _ in range(k - 5):
            known_words.pop()

    print(max(answer))


main()
