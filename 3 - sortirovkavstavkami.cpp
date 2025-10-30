//ISTO4NIK: https://vscode.ru/prog-lessons/sortirovka-vstavkami-na-si.html

#include <stdio.h>
#include <malloc.h>

//сортировка вставками
void InsertionSort(int n, int mass[])
{
    int newElement, location;

    for (int i = 1; i < n; i++)
    {
        newElement = mass[i];
        location = i - 1;
        while(location >= 0 && mass[location] > newElement)
        {
            mass[location+1] = mass[location];
            location = location - 1;
        }
        mass[location+1] = newElement;
    }
}

int main()
{
    //ввод N
    int N;
    printf("Input N: ");
    scanf_s("%d", &N);
    //выделение памяти под массив
    int* mass;
    mass = (int *)malloc(N * sizeof(int));
    //ввод элементов массива
    printf("Input the array elements:\n");
    for (int i = 0; i < N; i++)
        scanf_s("%d", &mass[i]);
    //сортировка вставками
    InsertionSort(N, mass);
    //вывод отсортированного массива на экран
    printf("Sorted array:\n");
    for (int i = 0; i < N; i++)
        printf("%d ", mass[i]);
    printf("\n");
    //освобождение памяти
    free(mass);
    return 0;
}
