import com.devKit451.DepartmentSorter.Sorter.DepartmentSorter;
import com.devKit451.DepartmentSorter.Sorter.DepartmentSorterFactory;
import com.devKit451.DepartmentSorter.Sorter.SorterType;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

public class TestMain {

    @Test
    public void testSortDepartmentsDescending() {
        String[] strings = new String[]{
                "K1\\SK1",
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

        List<String> expectedSortedDepartments = Arrays.asList(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        );

        assertEquals(expectedSortedDepartments, sortedDepartments);
    }

    @Test
    public void testSortDepartmentsWithEmptyList() {
        List<String> emptyDepartments = Arrays.asList();

        DepartmentSorter departmentSorterDescending =
                DepartmentSorterFactory.getDepartmentSorter(SorterType.DESCENDING);

        List<String> sortedDepartments = departmentSorterDescending.
                                            sortDepartments(emptyDepartments);

        assertTrue(sortedDepartments.isEmpty());
    }

    @Test
    public void testSortDepartmentsWithSingleElement() {
        List<String> singleDepartment = Arrays.asList("K1");

        DepartmentSorter departmentSorterDescending =
                DepartmentSorterFactory.getDepartmentSorter(SorterType.DESCENDING);

        List<String> sortedDepartments = departmentSorterDescending.
                                            sortDepartments(singleDepartment);

        assertEquals(singleDepartment, sortedDepartments);
    }

    @Test
    public void testSortDepartmentsWithSameCodes() {
        String[] strings = new String[]{
                "K1",
                "K1",
                "K2",
                "K2",
                "K1\\SK1",
                "K1\\SK1"
        };

        List<String> departmentCodes = Arrays.asList(strings);

        DepartmentSorter departmentSorterDescending =
                DepartmentSorterFactory.getDepartmentSorter(SorterType.DESCENDING);

        List<String> sortedDepartments = departmentSorterDescending.
                                            sortDepartments(departmentCodes);

         List<String> expectedSortedDepartments = Arrays.asList(
                "K2",
                "K1",
                "K1\\SK1"
        );

        assertEquals(expectedSortedDepartments, sortedDepartments);
    }

    @Test
    public void testSortDepartmentsWithEmptyStrings() {
        String[] departments = new String[]{
                "K1\\SK1",
                "",
                "K1\\SK2",
                "K2",
                "K2\\SK1"
        };
        List<String> departmentCodes = Arrays.asList(departments);

        DepartmentSorter departmentSorterDescending =
                DepartmentSorterFactory.getDepartmentSorter(SorterType.DESCENDING);

        List<String> sortedDepartments = departmentSorterDescending.
                                            sortDepartments(departmentCodes);

        List<String> expected = Arrays.asList(
                "K2",
                "K2\\SK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1"
        );

        assertEquals(expected, sortedDepartments);
    }

    @Test
    public void testSortDepartmentsWithDifferentLevels() {
        String[] departments = new String[]{
                "K1\\SK1",
                "K1\\SK2",
                "K1",
                "K2\\SK1\\SSK1",
        };

        List<String> departmentCodes = Arrays.asList(departments);

        DepartmentSorter departmentSorterDescending =
                DepartmentSorterFactory.getDepartmentSorter(SorterType.DESCENDING);

        List<String> sortedDepartments = departmentSorterDescending.
                                            sortDepartments(departmentCodes);

        List<String> expected = Arrays.asList(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1"

        );

        assertEquals(expected, sortedDepartments);
    }

    @Test
    public void testSortDepartmentsWithLeadingAndTrailingSpaces() {
        String[] departments = new String[]{
                " K1\\SK1 ",
                " K1\\SK2 ",
                " K2 ",
                " K1\\SK1 "
        };

        List<String> departmentCodes = Arrays.asList(departments);

        DepartmentSorter departmentSorterDescending =
                DepartmentSorterFactory.getDepartmentSorter(SorterType.DESCENDING);

        List<String> sortedDepartments = departmentSorterDescending.
                                            sortDepartments(departmentCodes);

        List<String> expected = Arrays.asList(
                "K2",
                "K1",
                "K1\\SK2",
                "K1\\SK1"
        );

        assertEquals(expected, sortedDepartments);
    }
}
