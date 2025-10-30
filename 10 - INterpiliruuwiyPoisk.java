public class InterpolationSearch {

    public static int interpolationSearch(int[] arr, int x) {
        // Указываем начальный и конечный индексы массива
        int low = 0;
        int high = arr.length - 1;

        // Цикл продолжается, пока low <= high и значение x лежит в пределах диапазона [arr[low], arr[high]]
        while (low <= high && x >= arr[low] && x <= arr[high]) {
            // Если low == high, значит мы нашли элемент
            if (low == high) {
                if (arr[low] == x) {
                    return low;
                } else {
                    return -1;
                }
            }

            // Формула интерполяционного поиска для вычисления предполагаемого положения
            int pos = low + ((high - low) / (arr[high] - arr[low])) * (x - arr[low]);

            // Если элемент найден, возвращаем его индекс
            if (arr[pos] == x) {
                return pos;
            }

            // Если значение в текущей позиции больше искомого, ищем в левой части
            if (arr[pos] < x) {
                low = pos + 1;
            }
            // Если значение в текущей позиции меньше искомого, ищем в правой части
            else {
                high = pos - 1;
            }
        }
        return -1; // Элемент не найден
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        int x = 18;
        int result = interpolationSearch(arr, x);
        if (result == -1) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println("Элемент найден по индексу: " + result);
        }
    }
}
