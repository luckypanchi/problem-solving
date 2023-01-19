import sys

def main():
    n, m = map(int, sys.stdin.readline().split())
    matrix = list(range(n, m+1))

    answer = []

    for num in matrix:
        if num == 1: continue
        isTrue = True
        for i in range(2, int(num**0.5)+1):
            if num%i == 0: 
                isTrue = False
                break
        
        if isTrue: answer.append(num)

    for i in answer:
        print(i)



if __name__ == "__main__":
    main()