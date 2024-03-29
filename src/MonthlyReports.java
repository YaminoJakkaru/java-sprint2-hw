import java.util.ArrayList;
import java.util.HashMap;
public class MonthlyReports {
    public  HashMap<String, ArrayList<MonthlyRecord>> monthlyReports;

    public MonthlyReports() {
        monthlyReports = new HashMap<>();

    }

    public  void addMonthlyReports(String name, ArrayList<MonthlyRecord> Data) {
        monthlyReports.put(name, Data);
    }

    public  void printReport() {
        for (String monthName : monthlyReports.keySet()) {
            System.out.println(monthName);
            for (MonthlyRecord record : monthlyReports.get(monthName)) {
                System.out.println(record);
            }
        }
    }
    public  void givInfo() {

        for (String monthName : monthlyReports.keySet()) {
            System.out.println(monthName);
            double maxIncome = 0;
            String maxIncomeName = null;
            double maxExpense = 0;
            String maxExpenseName= null;
            for (MonthlyRecord record : monthlyReports.get(monthName)) {
                if (!record.isExpense) {
                    if (maxIncome < record.sumOfOne * record.quantity) {
                        maxIncome = record.sumOfOne * record.quantity;
                        maxIncomeName= record.itemName;
                    }
                } else {
                    if (maxExpense < record.sumOfOne * record.quantity) {
                        maxExpense = record.sumOfOne * record.quantity;
                        maxExpenseName= record.itemName;
                    }
                }
            }
            System.out.println("Самый прибыльный товар: "+maxIncomeName+" - "+maxIncome);
            System.out.println("Самая большая трата: "+maxExpenseName+" - "+maxIncome);
        }
    }
}


