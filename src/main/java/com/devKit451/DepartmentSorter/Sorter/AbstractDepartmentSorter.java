package com.devKit451.DepartmentSorter.Sorter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Абстрактный класс для сортировки подразделений.
 */
public abstract class AbstractDepartmentSorter implements DepartmentSorter {

    private static final Logger logger = LoggerFactory.getLogger(AbstractDepartmentSorter.class);

    /**
     * Добавляет отсутствующие подразделения к списку.
     *
     * @param departmentsArray массив строк с кодами подразделений
     * @return список всех подразделений, включая добавленные родительские
     *  если входной массив равен null или пуст возвращает пустой лист
     */

    List<String> addMissingDepartmentsList(List<String> departmentsArray) {
        if (departmentsArray == null || departmentsArray.isEmpty()) {
            logger.warn("Получен null массив подразделений, возвращаем пустой список.");
            return new ArrayList<>();
        }

        Set<String> allDepartmentsSet = new HashSet<>();

        for (String department : departmentsArray) {
            String[] splitString = department.split("\\\\");
            StringBuilder departmentStringBuilder = new StringBuilder();

            for (String part : splitString) {
                part = part.trim();
                if (!part.isEmpty()) {
                    if (!departmentStringBuilder.isEmpty()) {
                        departmentStringBuilder.append("\\");
                    }
                    departmentStringBuilder.append(part);
                    allDepartmentsSet.add(departmentStringBuilder.toString());
                } else {
                    logger.warn("Пропущена некорректная часть подразделения в строке: {}", part);
                }
            }
        }
        return new ArrayList<>(allDepartmentsSet);
    }


    public abstract List<String> sortDepartments(List<String> departmentsString);
}
