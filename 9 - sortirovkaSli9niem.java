//INSO4NIK: https://arenda-server.cloud/blog/algoritm-sortirovki-slijaniem-na-java-c-i-python-kak-rabotaet/

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Рекурсивно сортируем левую и правую части
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Сливаем отсортированные части
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        // Размеры временных массивов
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Создаём временные массивы
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        // Копируем данные во временные массивы
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        // Сливаем временные массивы обратно в arr[left..right]
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        // Копируем оставшиеся элементы
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        
        mergeSort(arr, 0, arr.length - 1);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}
