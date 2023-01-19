import sys

def main():
    n = int(sys.stdin.readline())

    bag = 0
    while 1:
        if n%5 == 0:
            bag += n//5
            break
        n -= 3
        bag += 1
        if n < 0: 
            bag = -1
            break
    print(bag)

if __name__ == "__main__":
    main()