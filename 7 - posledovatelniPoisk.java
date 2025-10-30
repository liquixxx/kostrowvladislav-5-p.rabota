public class SequentialSearch {

    // Метод для выполнения последовательного поиска
    public static int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Возвращает индекс найденного элемента
            }
        }
        return -1; // Возвращает -1, если элемент не найден
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 10, 40};
        int target = 10;
        int result = sequentialSearch(numbers, target);

        if (result == -1) {
            System.out.println("Элемент не найден в массиве.");
        } else {
            System.out.println("Элемент найден на позиции: " + result);
        }
    }
}
