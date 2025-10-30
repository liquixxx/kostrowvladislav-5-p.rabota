//ISTO4NIK: https://vscode.ru/prog-lessons/sortirovka-shella.html

#include <stdio.h>
#include <malloc.h>
#include <conio.h>

//сортировка методом Шелла
void ShellSort(int n, int mass[])
{
    int i, j, step;
    int tmp;
    for (step = n / 2; step > 0; step /= 2)
        for (i = step; i < n; i++)
        {
            tmp = mass[i];
            for (j = i; j >= step; j -= step)
            {
                if (tmp < mass[j - step])
                    mass[j] = mass[j - step];
                else
                    break;
            }
            mass[j] = tmp;
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
    //сортировка методом Шелла
    ShellSort(N, mass);
    //вывод отсортированного массива на экран
    printf("Sorted array:\n");
    for (int i = 0; i < N; i++)
        printf("%d ", mass[i]);
    printf("\n");
    //освобождение памяти
    free(mass);
    _getch();
    return 0;
}
