import java.util.ArrayList;

public  class MonthlyData {
    public  ArrayList <MonthlyRecord> monthlyData;
    public MonthlyData(){
        monthlyData=new ArrayList<>();
    }
    public  void addMonthlyData(MonthlyRecord record){
        monthlyData.add(record);

    }



}


