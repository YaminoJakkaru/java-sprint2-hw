import java.util.Scanner;
public class CheckingReports {
    public static void checkReports() {
        Scanner scanner = new Scanner(System.in);

        String year = "2021";

        String[] months = {"01","02","03"};

        for (String month : months) {
            String monthName = year + month;

            System.out.println(monthName);
            if (!MonthlyReports.monthlyReports.containsKey(monthName)) {
                System.out.println("Нет отчета за  месяц" + monthName);
                return;
            }
            if (!AnnualReports.annualReports.containsKey(year)) {
                System.out.println("Нет данных за " + year + "год");
                return;
            }

            if (MonthlyReports.totalExpense(monthName) != AnnualReports.giveExpenseData(month, year)) {
                System.out.println("Данные о тратах не совпадают:" + MonthlyReports.totalExpense(monthName) + " месячном отчете, и" + AnnualReports.giveExpenseData(month, year)+" годовом");


                return;
            }
            if (MonthlyReports.totalIncome(monthName) != AnnualReports.giveIncomeData(month, year)) {
                System.out.println("Данные о доходах не совпадают:" + MonthlyReports.totalIncome(monthName) + "месячномотчете, и " + AnnualReports.giveIncomeData(month, year)+"в годовом");
                return;
            }
            System.out.println("Обшие доходы за месяц указаные в месяном отчете  - "+ MonthlyReports.totalIncome(monthName));
            System.out.println("Обшие доходы за месяц указаные в годовом отчете  - "+ AnnualReports.giveIncomeData(month, year));
            System.out.println("Обшие расходы за месяц указаные в месяном отчете  - "+ MonthlyReports.totalExpense(monthName));
            System.out.println("Обшие расходы за месяц указаные в годовом отчете  - "+ AnnualReports.giveExpenseData(month, year));
            System.out.println("Все верно");

        }
    }
}
