import sys
import itertools

def main():
    n = int(sys.stdin.readline())
    s = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

    li = list(itertools.combinations(range(n), n//2))

    answer = []

    def getAbility(arr):
        tmp = 0
        for i in arr:
            for j in arr:
                tmp += s[i][j]

        return tmp

    for arr1 in li:
        arr2 = []
        for i in range(n):
            if i not in arr1: 
                arr2.append(i)
        
        res1 = getAbility(arr1)
        res2 = getAbility(arr2)

        answer.append(abs(res1-res2))

    print(min(answer))


if __name__ == "__main__":
    main()