package Services;

public class ExceptCreateService {
    DataParsingService dataService = new DataParsingService();

    public void dataCompletenessCheck(String[] array, int count) {
        if(array.length > count) throw new StringIndexOutOfBoundsException();
        if(array.length < count) throw new IndexOutOfBoundsException();
    }

    public void surnameCheck(String[] array) {
        if(dataService.getSurname(array) == null) throw new IllegalArgumentException();
    }

    public void patronymicCheck(String[] array) {
        if(dataService.getPatronymic(array) == null) throw new IllegalArgumentException();
    }

    public void genderCheck(String[] array) {
        if(dataService.getGender(array) == null) throw new IllegalArgumentException();
    }

    public void birthDateCheck(String[] array) {
        if(dataService.getBirthDate(array) == null) throw  new NumberFormatException();
    }

    public void phoneNumberCheck(String[] array) {
        if(dataService.getTelephoneNumber(array) == null) throw  new NumberFormatException();
    }

    public void nameCheck(String[] array) {
        if(dataService.getName(array) == null) throw new IllegalArgumentException();
    }

}  