//ISTO4NIK: https://javarush.com/groups/posts/1062-sortirovka-vstavkami

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    // Главный метод программы
    public static void main(String[] args) throws IOException {
        // Создаем массив, вводя данные с клавиатуры
        int[] arr = createArray();
        System.out.println(Arrays.toString(arr)); // Выводим исходный массив
        
        // Сортируем массив двумя способами (один закомментирован)
        //int[] arr1 = sortArray(arr);    // Простая сортировка вставками
        int[] arr1 = sortArray1(arr);     // Оптимизированная сортировка
        
        System.out.println(Arrays.toString(arr1)); // Выводим отсортированный массив
    }
    
    // Метод для создания массива из 10 элементов, вводимых пользователем
    public static int[] createArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[10]; // Создаем массив на 10 элементов
        
        // Заполняем массив числами, введенными пользователем
        for (int i = 0; i < result.length; i++)
            result[i] = Integer.parseInt(reader.readLine()); // Читаем строку и преобразуем в число
        return result;
    }
    
    // Простая сортировка вставками (Insertion Sort)
    public static int[] sortArray(int[] array) {
        // Начинаем со второго элемента (i=1)
        for (int i = 1; i < array.length; i++) {
            int currVal = array[i];  // Запоминаем текущий элемент
            int keyPrev = i - 1;     // Индекс предыдущего элемента
            
            // Сдвигаем элементы большие чем currVal вправо
            while ((keyPrev >= 0) && (currVal < array[keyPrev])) {
                array[keyPrev + 1] = array[keyPrev]; // Сдвигаем элемент вправо
                array[keyPrev] = currVal;            // Вставляем текущее значение
                keyPrev--;                           // Переходим к следующему элементу слева
            }
        }
        return array;
    }
    
    // Оптимизированная сортировка вставками с бинарным поиском и System.arraycopy
    public static int[] sortArray1(int[] array) {
        // Проходим по всем элементам начиная со второго
        for (int i = 1; i < array.length; i++) {
            int currVal = array[i];  // Текущий элемент для вставки
            int keyPrev = i - 1;     // Граница отсортированной части
            
            // Бинарный поиск позиции для вставки в отсортированной части
            int searchResult = Arrays.binarySearch(array, 0, i, currVal);
            
            if (searchResult >= 0) {
                // Если элемент найден, вставляем после найденной позиции
                System.arraycopy(array, searchResult, array, searchResult + 1, i - searchResult);
                array[searchResult] = currVal;
            } else {
                // Если элемент не найден, вычисляем позицию для вставки
                int insertPosition = Math.abs(searchResult) - 1;
                // Копируем часть массива чтобы освободить место для вставки
                System.arraycopy(array, insertPosition, array, insertPosition + 1, i - insertPosition);
                array[insertPosition] = currVal; // Вставляем элемент
            }
        }
        return array;
    }
}
