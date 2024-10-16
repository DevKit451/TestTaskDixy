package com.devKit451.DepartmentSorter.Sorter;

/**
 * Класс для создания новых экземпляров сортировщиков.
 */
public class DepartmentSorterFactory {
    /**
     * Возвращает экземпляр DepartmentSorter на основе указанного типа сортировки.
     *
     * @param type тип сортировщика (например, DESCENDING)
     * @return экземпляр DepartmentSorter
     * @throws UnsupportedOperationException если тип сортировщика не поддерживается
     */
    public static DepartmentSorter getDepartmentSorter(SorterType type) {
        switch (type) {
            case DESCENDING:
                return new DepartmentSorterDescending();
            default:
                throw new UnsupportedOperationException("Неизвестный тип сортировщика: " + type);
        }
    }
}
