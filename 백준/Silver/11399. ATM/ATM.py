import sys

def main():
    n = int(sys.stdin.readline())
    li = list(map(int, sys.stdin.readline().split()))

    li.sort()
    answer = 0

    for i in li:
        answer += n * i
        n -= 1

    print(answer)


if __name__ == "__main__":
    main()