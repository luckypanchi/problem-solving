import sys
import itertools

def main():
    n = int(sys.stdin.readline())
    matrix = list(range(1, n+1))
    
    total = list(itertools.permutations(matrix, n))

    for arr in total:
        print(*arr)


if __name__ == "__main__":
    main()