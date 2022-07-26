public class AnnualRecord {
String month;
double amount;
boolean isExpense;
public AnnualRecord(String month, double amount,boolean isExpense){
    this.month= month;
    this.amount= amount;
    this.isExpense= isExpense;
}
    @Override
    public String toString(){
        return ("Имя:"+month+ " Цена:"+amount+ " Трата:"+isExpense);
    }
}
