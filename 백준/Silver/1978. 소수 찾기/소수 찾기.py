import sys

def main():
    n = int(sys.stdin.readline())
    matrix = list(map(int, sys.stdin.readline().split()))

    answer = 0

    for num in matrix:
        if num == 1: continue
        isTrue = True
        for i in range(2, num):
            if num%i == 0: 
                isTrue = False
                break
        
        if isTrue: answer += 1

    print(answer)



if __name__ == "__main__":
    main()