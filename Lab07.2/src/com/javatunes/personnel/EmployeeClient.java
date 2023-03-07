package com.javatunes.personnel;

class EmployeeClient {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        long begin = System.nanoTime();
        emp1.work();
        emp1.pay();
        long end = System.nanoTime();

        double elapsedMills = (end - begin) / 1_000_000.0;
        System.out.println(elapsedMills);
    }
}