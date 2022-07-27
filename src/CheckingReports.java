import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
public class CheckingReports {
    public  void checkReports(  HashMap<String,ArrayList<AnnualRecord>>annualReports,HashMap<String, ArrayList<MonthlyRecord>> monthlyReports) {
        Scanner scanner = new Scanner(System.in);

        String year = "2021";

        String[] months = {"01", "02", "03"};

        for (String month : months) {
            String monthName = year + month;

            System.out.println(monthName);
            if (!monthlyReports.containsKey(monthName)) {
                System.out.println("Нет отчета за  месяц" + monthName);
                return;
            }
            if (!annualReports.containsKey(year)) {
                System.out.println("Нет данных за " + year + "год");
                return;
            }

            if (totalExpense(monthName,monthlyReports) != giveExpenseData(month, year, annualReports)) {
                System.out.println("Данные о тратах не совпадают:" + totalExpense(monthName,monthlyReports) + " месячном отчете, и" + giveExpenseData(month, year, annualReports) + " годовом");


                return;
            }
            if (totalIncome(monthName,monthlyReports) != giveIncomeData(month, year, annualReports)) {
                System.out.println("Данные о доходах не совпадают:" + totalIncome(monthName,monthlyReports) + "месячномотчете, и " + giveIncomeData(month, year, annualReports) + "в годовом");
                return;
            }
            System.out.println("Обшие доходы за месяц указаные в месяном отчете  - " + totalIncome(monthName,monthlyReports));
            System.out.println("Обшие доходы за месяц указаные в годовом отчете  - " + giveIncomeData(month, year, annualReports));
            System.out.println("Обшие расходы за месяц указаные в месяном отчете  - " + totalExpense(monthName,  monthlyReports));
            System.out.println("Обшие расходы за месяц указаные в годовом отчете  - " + giveExpenseData(month, year, annualReports));
            System.out.println("Все верно");

        }



    }
    public double giveIncomeData (String month, String
            year, HashMap < String, ArrayList < AnnualRecord >> annualReports){

        double monthlyIncome = 0;

        for (AnnualRecord annualRecord : annualReports.get(year)) {
            if (month.equals(annualRecord.month) && !annualRecord.isExpense) {
                monthlyIncome = annualRecord.amount;
            }
        }
        return monthlyIncome;
    }
    public  double giveExpenseData(String month, String year,HashMap < String, ArrayList < AnnualRecord >> annualReports) {
        double monthlyExpense = 0;


        for (AnnualRecord annualRecord :  annualReports.get(year)) {
            if (month.equals(annualRecord.month) && annualRecord.isExpense) {
                monthlyExpense = annualRecord.amount;

            }

        }
        return monthlyExpense;
    }
    public  double totalIncome(String name,HashMap<String, ArrayList<MonthlyRecord>> monthlyReports) {
        double sum = 0;

        for (MonthlyRecord monthlyRecord : monthlyReports.get(name)) {
            if (!(monthlyRecord.isExpense)) {
                sum += monthlyRecord.sumOfOne * monthlyRecord.quantity;
            }
        }

        return sum;
    }

    public  double totalExpense(String name,HashMap<String, ArrayList<MonthlyRecord>> monthlyReports) {
        double sum = 0;

        for (MonthlyRecord monthlyRecord : monthlyReports.get(name)) {
            if (monthlyRecord.isExpense) {
                sum += monthlyRecord.sumOfOne * monthlyRecord.quantity;
            }
        }

        return sum;
    }
}
