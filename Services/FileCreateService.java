package Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreateService {

    DataParsingService dataService = new DataParsingService();

    public void writeInFile(FileWriter fw, String[] array ) {
        try {
            fw.write("<" + dataService.getSurname(array) + ">" +
                    "<" + dataService.getName(array) + ">" +
                    "<" + dataService.getPatronymic(array) + ">" +
                    "<" + dataService.getBirthDate(array) + ">" +
                    "<" + dataService.getTelephoneNumber(array) + ">" +
                    "<" + dataService.getGender(array) + ">");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String[] array) {
        try {
            File file = new File(dataService.getSurname(array) + ".txt");
            if (file.exists()) {
                FileWriter fw = new FileWriter(file, true);
                fw.append('\n');
                writeInFile(fw, array);
                System.out.println("Information successfully append to data file");
            }
            else {
                FileWriter fw = new FileWriter(file, true);
                writeInFile(fw, array);
                System.out.println("New data file successfully created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
