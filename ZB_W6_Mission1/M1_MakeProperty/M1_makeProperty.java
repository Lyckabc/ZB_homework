/******************************************************
 **                                                  **
 **        99_ZBTest                                 **
 **        M1_MakeProperty                    **
 **        Made by Toji                              **
 **        1/11/2024  2:04 AM                       **
 **        https://github.com/lyckabc                **
 **                                                  **
 ******************************************************/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class M1_makeProperty {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        try (FileWriter writer = new FileWriter("property.html")) {
            writer.write("<html><head><meta charset=\"UTF-8\"/><style>table {width: 100%; border-collapse: collapse;} th, td {border: 1px solid black;}</style></head><body>");
            writer.write("<table>");
            properties.forEach((key, value) -> {
                try {
                    writer.write("<tr><td>" + key + "</td><td>" + value + "</td></tr>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write("</table></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}