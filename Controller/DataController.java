package Controller;

import Services.DataParsingService;
import Services.ExceptCreateService;
import Services.FileCreateService;

public class DataController {

    ExceptCreateService exceptionService = new ExceptCreateService();
    DataParsingService dataService = new DataParsingService();
    FileCreateService fileService = new FileCreateService();

    public Boolean checkData(String data) {
        String[] array = dataService.getStringArray(data);
        Boolean isCorrect = true;

        try {
            exceptionService.dataCompletenessCheck(array, 6);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Too much information. Program will be closed");
            return isCorrect = false;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Information not enough. Program will be closed");
            return isCorrect = false;
        }

        try {
            exceptionService.surnameCheck(array);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect surname. Program will be closed");
            return isCorrect = false;
        }

        try {
            exceptionService.patronymicCheck(array);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect patronymic. Program will be closed");
            return isCorrect = false;
        }

        try {
            exceptionService.genderCheck(array);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect gender. Program will be closed");
            return isCorrect = false;
        }

        try {
            exceptionService.birthDateCheck(array);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect date of birth. Program will be closed");
            return isCorrect = false;
        }

        try {
            exceptionService.phoneNumberCheck(array);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect phone number. Program will be closed");
            return isCorrect = false;
        }
                
        try {
            exceptionService.nameCheck(array);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect name. Program will be closed");
            return isCorrect = false;
            }

        return isCorrect;
    }

    public void appendDataInFile(String data) {
        fileService.createFile(dataService.getStringArray(data));
    }
}