import java.util.ArrayList;

public class MonthFileUtil {

    public ArrayList<MonthlyRecord>  constructReport(String fileNames) {
        String[]months = fileNames.split(",");
        for (String month : months) {
            Reader reader = new Reader();
            MonthlyData data = new MonthlyData();
            String contentOfFile = reader.readFileContentsOrNull("resources/m." + month + ".csv");
            if (contentOfFile == null) {
                return null;
            }
            String[] lines = contentOfFile.split(System.lineSeparator());


            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");

                String itemName = lineContents[0];
                boolean isExpense = Boolean.parseBoolean(lineContents[1]);
                int quantity = Integer.parseInt(lineContents[2]);
                double sumOfOne = Double.parseDouble(lineContents[3]);
                MonthlyRecord monthlyRecord = new MonthlyRecord(itemName, isExpense, quantity, sumOfOne);
                data.addMonthlyData(monthlyRecord);

            }


            return data.monthlyData;

        }
        return null;
    }
}
