import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReports monthlyReports= new MonthlyReports();
        AnnualReports annualReports= new AnnualReports();
        CheckingReports checkingReports= new CheckingReports();
        printMenu();
        int userInput = scanner.nextInt();
        while (true) {
            switch (userInput) {
                case 1: {
                    MonthFileUtil.constructReport("202101,202102,202103");

                    monthlyReports.printReport();
                    break;
                }
                case 2: {

                    AnnualFileUtil.constructReport("2021");
                    annualReports.printReport();
                    break;
                }
                case 3: {
                   checkingReports.checkReports();
                    break;
                }
                case 4:{
                    monthlyReports.givInfo();
                    break;
                }
                case 5:{

                   annualReports.giveInfo("2021");
                    break;
                }
                case 0: {
                    System.out.println("Выход.");
                    return;
                }
                default: {
                    System.out.println("Извините, такой команды пока нет.");
                    break;
                }
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }
    private static void printMenu(){
        System.out.println("1-Считать все месячные отчёты\n" +
                "2-Считать годовой отчёт\n" +
                "3-Сверить отчёты\n" +
                "4-Вывести информацию о всех месячных отчётах\n" +
                "5-Вывести информацию о годовом отчёте\n" +
                "0- выход");
    }
}

