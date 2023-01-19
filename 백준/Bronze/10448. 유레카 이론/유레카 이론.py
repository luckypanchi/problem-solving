import sys
input = sys.stdin.readline

def main():
    n = int(input())
    answer = []
    for _ in range(n):
        num = int(input())

        limit = 0

        while True:
            if limit*(limit+1)/2 > num:
                break
            else: limit += 1

        stop = False
        for i in range(1, limit):
            tmp = 0
            tmp += i*(i+1)/2
            for j in range(1, limit):
                tmp += j*(j+1)/2
                for k in range(1, limit):
                    tmp += k*(k+1)/2
                    if tmp == num: 
                        answer.append(1)
                        stop = True
                        break
                    tmp -= k*(k+1)/2
                if stop: break
                tmp -= j*(j+1)/2            
            if stop: break
            tmp -= i*(i+1)/2

        if not stop: answer.append(0)

    for i in answer:
        print(i)

if __name__ == "__main__":
    main()