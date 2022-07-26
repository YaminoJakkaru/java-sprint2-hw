public class AnnualFileUtil {
    public static void constructReport(String fileNames) {


        Reader reader = new Reader();
        AnnualData data= new AnnualData();
        String contentOfFile = reader.readFileContentsOrNull("resources/y."+fileNames+".csv");
        if (contentOfFile==null){
            return;
        }
        String[] lines = contentOfFile.split(System.lineSeparator());



        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            String month = lineContents[0];
            double amount = Double.parseDouble(lineContents[1]);
           Boolean isExpense= Boolean.parseBoolean(lineContents[2]);
            AnnualRecord record = new AnnualRecord(month, amount ,isExpense);
            data.addAnnualData(record);

        }


        AnnualReports.addAnnualReports(fileNames,data.annualData);

    }
}

