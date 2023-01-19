import sys
input = sys.stdin.readline
import itertools


def main():
    matrix = []
    for _ in range(9):
        matrix.append(int(input()))

    candidates = list(itertools.combinations(matrix, 7))
    
    for arr in candidates:
        if sum(list(arr)) == 100:
            for i in arr:
                print(i)

if __name__ == "__main__":
    main()