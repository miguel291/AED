# Mooshack version 2
import math


def shellSort(array, n, increments):
    k = 1
    length = len(increments)
    while k <= length:
        interval = increments[length-k]
        k += 1
        for i in range(interval, n):
            temp = array[i]
            j = i
            while j >= interval and array[j - interval] > temp:
                array[j] = array[j - interval]
                j -= interval
            array[j] = temp


size = int(input())
data = []
for i in range(size):
    data.append(int(input()))
increments = []
# increments.append(1)  # Needed for Papernov & Stasevich and Sedgewick
# increments.append(math.floor(size/2))  # Needed for Base shellSort
i = 0
while (True):
    i = i + 1
    # num = math.floor(increments[i-1]/2)  # Base shellSort
    # num = pow(4, i+1) + 3*pow(2, i) + 1   # Sedgewick
    # num = pow(2, i) + 1  # Papernov & Stasevich'''
    # num = pow(2,i) - 1 #Hibbard
    num = (pow(3, i) - 1) // 2  # Knuth
    if (num < size):     # < Size or > 0 in the base version
        increments.append(num)
    else:
        break
# increments.reverse()  # Only used for base version
shellSort(data, size, increments)
for i in range(size):
    print(data[i])
