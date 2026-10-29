def swap(ary, first, second):
    ary[first], ary[second] = ary[second], ary[first]

def quick_sort(ary, start, end):
    if start >= end: return

    pivot = ary[start]
    left = start + 1
    right = end

    while left <= right:
        while left <= end and ary[left] < pivot: left += 1
        while right > start and ary[right] > pivot: right -= 1
        if left <= right:
            swap(ary, left, right)
            left += 1
            right -= 1

    center = right
    swap(ary, start, center)
    quick_sort(ary, start, center - 1)
    quick_sort(ary, center + 1, end)

def search(line, size):
    result = set()

    for start in range(size):
        for end in range(start + 1, size + 1):
            result.add(line[start:end])

    return result

def algorithm():
    N = int(input())
    line = input()

    split_lines = search(line, len(line))
    size = len(split_lines)

    if N > size: return 'none'

    line_list = list(split_lines)
    quick_sort(line_list, 0, size - 1)
    return line_list[N - 1]

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
