import java.util.ArrayList;
import java.util.HashMap;
public class AnnualReports {
     public   HashMap<String,ArrayList<AnnualRecord>>annualReports;

    public AnnualReports(){
        annualReports=new HashMap<>();

    }

    public  void addAnnualReports(String name, ArrayList<AnnualRecord> data){
        annualReports.put(name,data);
    }
    public  void printReport(){
        for ( String annualName:  annualReports.keySet()){
            System.out.println(annualName);
            for (AnnualRecord record: annualReports.get(annualName)){
                System.out.println(record);
            }
        }
    }


    public void giveInfo(String annualName){
       if(!annualReports.containsKey(annualName)){
           System.out.println("Нет отчета за этот год");
            return;
       }
            System.out.println(annualName);
           monthlyProfits(annualReports.get(annualName));
            System.out.println("Средний расход - "+averageExpense(annualReports.get(annualName)));
           System.out.println("Средний доход - "+averageIncome(annualReports.get(annualName)));


    }
    public  double averageIncome(ArrayList<AnnualRecord> annualReports ){
        double totalIncome=0;
        int month=0;
        for (AnnualRecord reports: annualReports){
          if(!reports.isExpense){
              totalIncome+=reports.amount;
              month++;
          }

        }
        return totalIncome/month;
    }
    public  double averageExpense(ArrayList<AnnualRecord> annualReports ){
        double totalExpense=0;
        int month=0;
        for (AnnualRecord reports: annualReports){
            if(!reports.isExpense){
                totalExpense+=reports.amount;
                month++;
            }

        }
        return totalExpense/month;
    }
    public  void monthlyProfits(ArrayList<AnnualRecord> annualReports) {
        double expense = 0;
        double income = 0;
        String month = null;
        for (AnnualRecord reports : annualReports) {
            if (reports.month.equals(month)) {
                expense = reports.isExpense ? reports.amount : expense;
                income = !reports.isExpense ? reports.amount : income;
                System.out.println("Прибыль за "+month+"-"+(income-expense));
            }
            else{
                month=reports.month;
            }
        }
    }

}
