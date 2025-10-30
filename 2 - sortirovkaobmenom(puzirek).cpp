//ISTO4NIK: https://prog-cpp.ru/sort-bubble/

#define _CRT_SECURE_NO_WARNINGS // для корректной работы scanf()
#include <stdio.h>
#define SIZE 10  // размер массива сортируемых элементов
// Функция сортировки прямыми включениями
void bubbleSort(int* num, int size)
{
    // Для всех элементов
    for (int i = 0; i < size - 1; i++)
    {
        for (int j = (size - 1); j > i; j--) // для всех элементов после i-ого
        {
            if (num[j - 1] > num[j]) // если текущий элемент меньше предыдущего
            {
                int temp = num[j - 1]; // меняем их местами
                num[j - 1] = num[j];
                num[j] = temp;
            }
        }
    }
}
int main()
{
    int a[SIZE]; // Объявляем массив из 10 элементов
    // Вводим значения элементов массива
    for (int i = 0; i < SIZE; i++)
    {
        printf("a[%d] = ", i);
        scanf("%d", &a[i]);
    }
    bubbleSort(a, SIZE);  // вызываем функцию сортировки
    // Выводим отсортированные элементы массива
    for (int i = 0; i < SIZE; i++)
        printf("%d ", a[i]);
    getchar();
    getchar();
    return 0;
}
