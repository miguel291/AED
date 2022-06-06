import math

def switcharoo(first,second,arr):
    temp = 0
    if(arr[first]>arr[second]):
            temp = arr[first]
            arr[first] = arr[second]
            arr[second]= temp
    return arr


def quickSort(low, high, arr):
    n = high
    temp = 0
    pivot = 0
    j = 0
    k = 0
    media = int(math.floor((high-low)/2))
    y = low
    z = high-2
    #Insertion sort
    if (high-low < 3):
        #print("high : " +str(high) +" low :" + str(low))
        for i in range(low, high):
            key = arr[i]
            j = i-1
            while j >=0 and key < arr[j] :
                    arr[j+1] = arr[j]
                    j -= 1
            arr[j+1] = key
        #print(arr)
        return(arr)
    #Quick sort
    else:
        arr = switcharoo(low, low+media, arr)
        arr = switcharoo(low, high-1, arr)
        arr = switcharoo(low+media, high-1 ,arr)
        pivot = arr[low +media]
        #print("PICOR:"+ str(pivot))
        arr[low + media] = arr[high-1]
        arr[high-1] = pivot
        while (j<=high-1):
            if(arr[j]<=pivot):
                temp = arr[j]
                arr[j] = arr[k]
                arr[k] = temp
                k+=1
            j+=1
        #print(arr)
        quickSort(0,k-1,arr)
        quickSort(k+1,high,arr)

    return arr


if __name__ == "__main__":
    size = int(input())
    data = []
    for i in range(size):
        data.append(int(input()))
    quickSort(0, len(data),data)
    for i in range(size):
        print(data[i])
