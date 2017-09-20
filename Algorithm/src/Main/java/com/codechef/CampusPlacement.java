package com.codechef;

import com.algo.Output;

import java.util.Scanner;

/**
 * Created by soumya on 12/08/17.
 */

public class CampusPlacement {

    static class Student {
        int minSalary = 0;
        Company selectedCompany = null;

        Student(int minSalary) {
            this.minSalary = minSalary;
            selectedCompany = null;
        }

        public int getMinSalary() {
            return minSalary;
        }


        public Company getSelectedCompany() {
            return selectedCompany;
        }

        public void setSelectedCompany(Company selectedCompany) {
            this.selectedCompany = selectedCompany;
        }

        @Override
        public String toString() {
            if (selectedCompany == null) {
                return "minSalary = " + minSalary + "selected company null";
            } else {
                return "minSalary = " + minSalary + "selectedcompany" + selectedCompany.toString();
            }
        }
    }

    static class Company {
        int offeredSalary = 0;
        int capacity = 0;
        int candidates_selected = 0;

        Company(int offeredSalary,int capacity) {
            this.offeredSalary = offeredSalary;
            this.capacity = capacity;
            candidates_selected = 0;
        }

        public int getOfferedSalary() {
            return offeredSalary;
        }

        public void setOfferedSalary(int offeredSalary) {
            this.offeredSalary = offeredSalary;
        }

        public int getCapacity() {
            return capacity - candidates_selected;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public int getCandidates_selected() {
            return candidates_selected;
        }

        public void incrementNumOfCandidateSelected() {
            this.candidates_selected++;
        }

        public void decrementNumOfCandidateSelected() {
            this.candidates_selected--;
        }

        @Override
        public String toString() {
            return "offered Salary " + offeredSalary + " capacity = " + capacity
                    + "candidates_selected" + candidates_selected;
        }
    }


    private static void check(Student student, Company company) {

        if (student.getMinSalary() <= company.getOfferedSalary()) {
            if (student.getSelectedCompany() == null) {
                if (company.getCapacity() > 0) {
                    if (company.getCandidates_selected()==0) {
                        num_full_vacancy_company--;
                       // System.out.println("num1--"+num_full_vacancy_company);
                    }
                    student.setSelectedCompany(company);
                    company.incrementNumOfCandidateSelected();
                    num_placed_Student++;
                    tot_sal_offered += student.getSelectedCompany()
                            .getOfferedSalary();
                }
            } else if (student
                    .getSelectedCompany().getOfferedSalary() < company
                    .getOfferedSalary()) {
                if (company.getCapacity() > 0) {
                    student.getSelectedCompany().decrementNumOfCandidateSelected();
                    tot_sal_offered -= student.getSelectedCompany()
                            .getOfferedSalary();
                    if (student.getSelectedCompany().getCandidates_selected()==0) {
                        num_full_vacancy_company++;
                        //System.out.println("num1++"+num_full_vacancy_company);
                    }
                    if (company.getCandidates_selected()==0) {
                        num_full_vacancy_company--;
                        //System.out.println("num2--"+num_full_vacancy_company);
                    }
                    student.setSelectedCompany(company);
                    tot_sal_offered += student.getSelectedCompany()
                            .getOfferedSalary();
                    company.incrementNumOfCandidateSelected();
                }
            }
        }
    }
    private static void printoutPut() {
        System.out.print(num_placed_Student + " " + tot_sal_offered + " "+num_full_vacancy_company);
    }
    static int num_placed_Student = 0;
    static long tot_sal_offered = 0;
    static int num_full_vacancy_company = 0;

    public static void getInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
             num_placed_Student = 0;
             tot_sal_offered = 0;
            int N = sc.nextInt();

            int M = sc.nextInt();
            num_full_vacancy_company = M;
            Student[] students = new Student[N];
            Company[] companies = new Company[M];

            for (int j = 0; j < N; j++) {
                students[j] = new Student(sc.nextInt());
            }
            for (int k = 0; k < M; k++) {
                companies[k] = new Company(sc.nextInt(),sc.nextInt());
            }


            for (int j = 0; j < N; j++) {
                String s = sc.next();
                for (int k = 0; k < M; k++) {
                    char val = s.charAt(k);
                    if (val == '1') {
                        check(students[j],companies[k]);
                    }
                }
            }
            printoutPut();
            if (i<T-1) {
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        getInput();
    }

}
