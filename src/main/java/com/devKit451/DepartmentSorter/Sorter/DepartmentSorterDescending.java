package com.devKit451.DepartmentSorter.Sorter;

import java.util.List;

import com.devKit451.DepartmentSorter.Comparator.DepartmentComparator;

/**
 * Класс для сортировки подразделений по убыванию с сохранением иерархической структуры.
 */
public class DepartmentSorterDescending extends AbstractDepartmentSorter {

    /**
     * Сортирует массив подразделений по убыванию с сохранением иерархической структуры.
     *
     * @param departmentsString массив строк с кодами подразделений
     * @return отсортированный массив строк
     */
    @Override
    public List<String> sortDepartments(List<String> departmentsString) {

        List<String> allDepartmentsList = addMissingDepartmentsList(departmentsString);

        allDepartmentsList.sort(new DepartmentComparator());

        return allDepartmentsList;
    }
}
