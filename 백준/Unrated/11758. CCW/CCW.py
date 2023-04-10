import sys

input = sys.stdin.readline


class Node:
    def __init__(self, x, y):
        self.x = x
        self.y = y


def ccw(node1, node2, node3):
    cp = (
        node1.x * node2.y
        + node2.x * node3.y
        + node3.x * node1.y
        - node2.x * node1.y
        - node3.x * node2.y
        - node1.x * node3.y
    )

    if cp < 0:
        return -1
    elif cp == 0:
        return 0
    else:
        return 1


x1, y1 = map(int, input().split())
x2, y2 = map(int, input().split())
x3, y3 = map(int, input().split())

node1 = Node(x1, y1)
node2 = Node(x2, y2)
node3 = Node(x3, y3)

print(ccw(node1, node2, node3))