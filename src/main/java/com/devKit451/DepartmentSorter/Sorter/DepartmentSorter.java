package com.devKit451.DepartmentSorter.Sorter;

import java.util.List;

/**
 * Сортировщик подразделений.
 */
public interface DepartmentSorter {
    /**
     * Сортирует список подразделений по определенному критерию.
     *
     * @param departmentsString список подразделений для сортировки
     * @return отсортированный список подразделений
     */
    List<String> sortDepartments(List<String> departmentsString);
}
