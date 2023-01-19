import sys

def main():
    min, max = map(int, sys.stdin.readline().split())
    matrix = [True for _ in range(min, max+1)]
    
    sqaured = [x ** 2 for x in range(2, int(max**0.5)+1)]
   
    for i in sqaured:
        tmp = min / i
        if tmp - int(tmp) != 0:
            tmp = int(tmp) + 1
        
        idx = i * int(tmp) - min

        while idx < max - min + 1:
            matrix[idx] = False
            idx += i
    
    answer = 0
    for i in matrix:
        if i: answer += 1
    print(answer)

if __name__ == "__main__":
    main()
