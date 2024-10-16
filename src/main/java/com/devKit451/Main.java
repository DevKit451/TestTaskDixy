package com.devKit451;

import com.devKit451.DepartmentSorter.Sorter.DepartmentSorterFactory;
import com.devKit451.DepartmentSorter.Sorter.DepartmentSorter;
import com.devKit451.DepartmentSorter.Sorter.SorterType;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};

        List<String> departmentCodes = Arrays.asList(strings);

        DepartmentSorter departmentSorterDescending =
                DepartmentSorterFactory.
                        getDepartmentSorter(SorterType.DESCENDING);


        List<String> sortedDepartments = departmentSorterDescending.
                sortDepartments(departmentCodes);

        System.out.println(sortedDepartments);
    }

}