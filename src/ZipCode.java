import java.io.*;
import java.util.Scanner;
public class ZipCode {
    public final static String CITIES= "municipios-calles.txt";
    public static String getText (int zipCode) throws IOException {
        File file = new File(CITIES);
        BufferedReader input = null;
        Scanner scan;
        String result = "";
        try {
            input = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = input.readLine()) != null) {
                scan = new Scanner(line);
                scan.useDelimiter(";");
                String codProvince = scan.next();
                String city = scan.next();
                String isCity = scan.next();
                String strZip = scan.next();
                if (Integer.parseInt(strZip) == zipCode) {
                    String zone = scan.next();
                    result += "codProvince: " + codProvince + "\n";
                    if (Boolean.parseBoolean(isCity)) {
                        result += "City: " + city + "\n";
                        result += "First street :" + zone +" \n";
                    } else {
                        result += "Province: " + city + "\n";
                        result += "City: " + zone + "\n";
                    }
                    result += "zip code: " + zipCode + "\n";
                    scan.close();
                    return result;
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File " + CITIES + " not found");
        } catch (IOException ex) {
            System.err.println("Error reading " + CITIES);
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return "";
    }
}