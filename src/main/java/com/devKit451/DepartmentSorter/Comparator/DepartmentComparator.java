package com.devKit451.DepartmentSorter.Comparator;

import java.util.Comparator;

/**
 * Компаратор для сортировки подразделений с учётом иерархии.
 * Сортировка осуществляется по убыванию.
 * Если все сравниваемые части равны, более короткий код считается "меньшим".
 */
public class DepartmentComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] parts1 = o1.split("\\\\");
        String[] parts2 = o2.split("\\\\");

        int minLength = Math.min(parts1.length, parts2.length);
        for (int i = 0; i < minLength; i++) {
            // Сравниваем по убыванию
            int cmp = parts2[i].compareTo(parts1[i]);
            if (cmp != 0) {
                return cmp;
            }
        }
        // Если все сравниваемые части равны, более короткая строка должна идти раньше
        return Integer.compare(parts1.length, parts2.length);
    }
}