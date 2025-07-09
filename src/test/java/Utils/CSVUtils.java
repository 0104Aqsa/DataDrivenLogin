package Utils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    private static List<String[]> data = new ArrayList<>();

    public static void loadCSVFile(String filePath) throws IOException {
        data.clear(); // Clear old data
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean isFirstLine = true;

        while ((line = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false; // skip header
                continue;
            }
            String[] row = line.split(",");
            data.add(row);
        }
        reader.close();
    }
//
//    public static String getCellData(int row, int column) {
//        return data.get(row)[column];
//    }
//    public static int getRowCount() {
//        return data.size();
//    }
//    public static void clearData() {
//        data.clear();
//    }

    // ✅ This is the missing DataProvider
    @DataProvider(name = "LoginData")
    public static Object[][] provideLoginData() throws IOException {
        String filePath = "C:/Users/Akshata/IdeaProjects/DataDrivenTestProject/TestData/UserNamePassword.csv";
        loadCSVFile(filePath);
        return data.toArray(new Object[0][]);
    }
}
