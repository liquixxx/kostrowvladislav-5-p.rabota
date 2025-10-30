//INSO4NIK: https://garden.struchkov.dev/ru/dev/java/%D0%91%D0%B8%D0%BD%D0%B0%D1%80%D0%BD%D1%8B%D0%B9-%D0%BF%D0%BE%D0%B8%D1%81%D0%BA-%D0%BD%D0%B0-Java

public class Binary {
 
    public static void main(String[] args) {
        // Создаем отсортированный массив для поиска (обязательное условие для бинарного поиска)
        int[] values = {1, 1, 2, 3, 4, 10};
        // Задаем значение, которое нужно найти в массиве
        int valueToFind = 3;
 
        // Вызываем бинарный поиск и выводим результат
        // Передаем массив, искомое значение, начальный индекс (0) и конечный индекс (длина-1)
        System.out.printf("Index = %d%n", binarySearch(values, valueToFind, 0, values.length - 1));
    }
 
    // Метод бинарного поиска в отсортированном массиве
    private static int binarySearch(int[] sortedArray, int valueToFind, int low, int high) {
        int index = -1; // Инициализируем индекс как -1 (значение не найдено)
 
        // Продолжаем поиск пока границы не пересекутся
        while (low <= high) {
            // Вычисляем средний индекс между low и high
            // Используется формула low + (high - low) / 2 вместо (low + high) / 2 
            // чтобы избежать переполнения при больших значениях
            int mid = low + (high - low) / 2;
            
            // Если элемент в середине МЕНЬШЕ искомого значения
            if (sortedArray[mid] < valueToFind) {
                low = mid + 1; // Сдвигаем левую границу вправо (ищем в правой половине)
            } 
            // Если элемент в середине БОЛЬШЕ искомого значения
            else if (sortedArray[mid] > valueToFind) {
                high = mid - 1; // Сдвигаем правую границу влево (ищем в левой половине)
            } 
            // Если элемент в середине РАВЕН искомому значению (успех!)
            else if (sortedArray[mid] == valueToFind) {
                index = mid; // Запоминаем индекс найденного элемента
                break;       // Выходим из цикла
            }
        }
        return index; // Возвращаем индекс элемента или -1 если не найден
    }
 
}
