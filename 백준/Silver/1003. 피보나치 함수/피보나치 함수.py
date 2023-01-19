import sys
input = sys.stdin.readline

def main():
    num = int(input())
    answer = []

    fib_arr = [0]*41
    fib_arr[0] = (1, 0)
    fib_arr[1] = (0, 1)

    def tupleSum(A, B):
        tmp = []
        for i in range(len(A)):
            tmp.append(A[i] + B[i])
        return tuple(tmp)

    def fib(n):
        if not fib_arr[n-2]:
            fib_arr[n-2] = fib(n-2)
        if not fib_arr[n-1]:
            fib_arr[n-1] = fib(n-1)
        return tupleSum(fib_arr[n-2], fib_arr[n-1])


    for _ in range(num):
        n = int(input())
        if not fib_arr[n]:
            fib_arr[n] = fib(n)
        answer.append(list(fib_arr[n]))

    for arr in answer:
        print(*arr)


if __name__ == "__main__":
    main()