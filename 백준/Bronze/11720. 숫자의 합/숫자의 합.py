import sys

def main():
    n = int(sys.stdin.readline())
    li = list(map(int, list(sys.stdin.readline()[:-1])))
    answer = 0

    for i in li:
        answer += int(i)

    print(answer)



if __name__ == "__main__":
    main()