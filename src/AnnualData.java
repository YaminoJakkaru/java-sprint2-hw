import java.util.ArrayList;

public class AnnualData {
    public static ArrayList<AnnualRecord> annualData;

    public AnnualData() {
        annualData = new ArrayList<>();
    }

    public static void addAnnualData(AnnualRecord record) {
        annualData.add(record);

    }




}
