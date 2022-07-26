import java.util.ArrayList;

public  class MonthlyData {
    public static ArrayList <MonthlyRecord> monthlyData;
    public MonthlyData(){
        monthlyData=new ArrayList<>();
    }
    public static void addMonthlyData(MonthlyRecord record){
        monthlyData.add(record);

    }



}


