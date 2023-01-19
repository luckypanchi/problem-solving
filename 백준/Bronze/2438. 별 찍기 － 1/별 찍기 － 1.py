import sys

def main():
    n = int(sys.stdin.readline())

    for i in range(n):
        print('*'*(i+1), end="\n")

if __name__ == "__main__":
    main()