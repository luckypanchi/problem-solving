import sys

input = sys.stdin.readline


def main():
    n = int(input())
    answer = 0
    for _ in range(n):
        sentence = input().strip()
        flag = [False] * 26
        previous = None
        end = False
        for letter in sentence:
            if flag[ord(letter) - ord("a")] and letter != previous:
                end = True
                break
            else:
                previous = letter
                flag[ord(letter) - ord("a")] = True
        if end:
            continue
        else:
            answer += 1
    print(answer)


main()
