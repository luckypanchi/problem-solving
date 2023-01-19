import sys

input = sys.stdin.readline


def main():
    target = input().strip()
    answer = 0
    idx = 0

    while idx < len(target):
        if target[idx : idx + 2] in ["c=", "c-", "d-", "lj", "nj", "s=", "z="]:
            answer += 1
            idx += 2
        elif target[idx : idx + 3] == "dz=":
            answer += 1
            idx += 3
        else:
            answer += 1
            idx += 1

    print(answer)


main()
