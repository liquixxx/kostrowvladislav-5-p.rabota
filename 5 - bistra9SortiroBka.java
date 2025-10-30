//ISTO4NIK: https://javarush.com/groups/posts/bihstraja-sortirovka-quicksort-v-java

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // Создаем тестовый массив для демонстрации работы алгоритма
        int[] array = {17, 14, 15, 28, 6, 8, -6, 1, 3, 18};
        
        // Выводим исходный (неотсортированный) массив
        System.out.println("Unsorted Array: " + Arrays.toString(array));
        
        // Вызываем быструю сортировку для всего массива
        // low = 0 (начальный индекс), high = array.length - 1 (конечный индекс)
        quickSort(array, 0, array.length - 1);
        
        // Выводим отсортированный массив
        System.out.println("  Sorted Array: " + Arrays.toString(array));
    }

    // Основной метод быстрой сортировки (рекурсивный)
    public static void quickSort(int[] arr, int low, int high) {
        // Базовый случай рекурсии: если есть что сортировать (low < high)
        if (low < high) {
            // Разбиваем массив и получаем индекс опорного элемента (pivot index)
            // После partition: все элементы слева от pi меньше опорного, справа - больше
            int pi = partition(arr, low, high);

            // Рекурсивно сортируем левую часть (элементы меньше опорного)
            quickSort(arr, low, pi - 1);
            
            // Рекурсивно сортируем правую часть (элементы больше опорного)
            quickSort(arr, pi + 1, high);
        }
    }

    // Метод для разделения массива относительно опорного элемента
    private static int partition(int[] arr, int low, int high) {
        // Выбираем опорный элемент - последний элемент подмассива
        int pivot = arr[high];
        
        // Индекс, который указывает на позицию, где будут размещены элементы меньше опорного
        // Начинаем с (low - 1), так как изначально нет элементов меньше опорного
        int i = (low - 1);
        
        // Проходим по всем элементам от low до high-1 (исключая опорный)
        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше опорного
            if (arr[j] < pivot) {
                i++; // Увеличиваем индекс для размещения меньшего элемента
                
                // Меняем местами arr[i] и arr[j]
                // Это перемещает меньший элемент в левую часть
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // После прохода по всем элементам, размещаем опорный элемент на правильную позицию
        // Все элементы слева от i+1 меньше опорного, справа - больше или равны
        int temp = arr[i + 1];
        arr[i + 1] = arr[high]; // Перемещаем опорный элемент на правильную позицию
        arr[high] = temp;
        
        // Возвращаем индекс опорного элемента
        return i + 1;
    }
}
