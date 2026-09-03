codes = []

def insert(orders, offset):
    global codes
    x, y = int(orders[offset]), int(orders[offset + 1])

    for idx in range(y):
        codes.insert(x + idx, orders[offset + 2 + idx])

    return offset + 2 + y

def add(orders, offset):
    global codes
    y = int(orders[offset])

    for idx in range(y):
        codes.append(orders[offset + 1 + idx])

    return offset + 1 + y

def delete(orders, offset):
    global codes
    x, y = int(orders[offset]), int(orders[offset + 1])
    for _ in range(y):
        codes.pop(x)

    return offset + 2

def algorithm():
    global codes

    N = int(input())
    codes = list(input().split())
    M = int(input())
    orders = list(input().split())

    offset = 0
    for _ in range(M):
        if orders[offset] == 'I':
            offset = insert(orders, offset + 1)
        elif orders[offset] == 'D':
            offset = delete(orders, offset + 1)
        elif orders[offset] == 'A':
            offset = add(orders, offset + 1)

    return " ".join(codes[0:10])

# T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 11):
    print(f"#{test_case} {algorithm()}")
