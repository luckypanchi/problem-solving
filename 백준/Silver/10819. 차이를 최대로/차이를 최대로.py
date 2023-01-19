import sys
import itertools


def main():
    n = int(sys.stdin.readline())
    matrix = list(map(int, sys.stdin.readline().split()))
    total = list(itertools.permutations(matrix, n))
    
    answer = []
    
    for arr in total:
        tmp = 0
        for i in range(n-1):
            tmp += abs(arr[i] - arr[i+1])
        answer.append(tmp)

    print(max(answer))
    
if __name__ == "__main__":
    main()