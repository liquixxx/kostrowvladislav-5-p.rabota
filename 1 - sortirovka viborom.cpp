//ISTO4NIK - https://prog-cpp.ru/sort-select/

#define _CRT_SECURE_NO_WARNINGS // для корректной работы scanf()
#include <stdio.h>
#define SIZE 10  // размер массива сортируемых элементов
// Функция сортировки прямыми включениями
void selectionSort(int* num, int size)
{
    int min, temp; // для поиска минимального элемента и для обмена
    for (int i = 0; i < size - 1; i++)
    {
        min = i; // запоминаем индекс текущего элемента
        // ищем минимальный элемент чтобы поместить на место i-ого
        for (int j = i + 1; j < size; j++)  // для остальных элементов после i-ого
        {
            if (num[j] < num[min]) // если элемент меньше минимального,
                min = j;       // запоминаем его индекс в min
        }
        if (min == i) continue;  // чтобы не менять элемент сам с собой
        temp = num[i];      // меняем местами i-ый и минимальный элементы
        num[i] = num[min];
        num[min] = temp;
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
    selectionSort(a, SIZE);  // вызываем функцию сортировки
    // Выводим отсортированные элементы массива
    for (int i = 0; i < SIZE; i++)
        printf("%d ", a[i]);
    getchar();
    getchar();
    return 0;
}
