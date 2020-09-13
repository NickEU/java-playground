package tf.nick.stuff.streams.pipelines.empManagement;

import java.util.List;

class EmployeesCounter {

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold is lower edge of salary
     *
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        String reqDepCodePrefix = "111-";
        return departments.stream()
            .filter(d -> d.getCode().startsWith(reqDepCodePrefix))
            .flatMap(d -> d.getEmployees().stream())
            .filter(e -> e.getSalary() >= threshold)
            .count();
    }

}
