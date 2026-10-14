def check_duple(board, r, c):
    visited = 0

    # block
    for row in range(3):
        for col in range(3):
            num = board[r + row][c + col]
            if (visited & (1 << num)) != 0: return True
            visited |= (1 << num)

    # row
    for row in range(3):
        visited = 0

        for col in range(9):
            num = board[r + row][col]
            if (visited & (1 << num)) != 0: return True
            visited |= (1 << num)

    # col
    for col in range(3):
        visited = 0

        for row in range(9):
            num = board[row][c + col]
            if (visited & (1 << num)) != 0: return True
            visited |= (1 << num)

    return False

def algorithm():
    board = [list(map(int, input().split())) for _ in range(9)]

    for row in range(0, 9, 3):
        for col in range(0, 9, 3):
            is_duple = check_duple(board, row, col)
            if is_duple: return 0

    return 1

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
