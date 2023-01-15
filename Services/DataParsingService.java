package Services;

public class DataParsingService {
    public String[] getStringArray(String str) {
        return str.split(" ");
    }

    public String getSurname(String[] array) {
        for (String item : array) {
            if(!item.equals(getPatronymic(array)) &&
                item.toLowerCase().contains("ов") || 
                item.toLowerCase().contains("ова") || 
                item.toLowerCase().contains("ев") || 
                item.toLowerCase().contains("ева")) {
                return item;
            }
        }
        return null;
    }

    public String getPatronymic(String[] array) {
        for (String item : array) {
            if(item.toLowerCase().contains("ович") || 
                item.toLowerCase().contains("овна") || 
                item.toLowerCase().contains("евич") || 
                item.toLowerCase().contains("евна")) {
                return item;
            }
        }
        return null;
    }

    public String getBirthDate(String[] array) {
        for (String item : array) {
            if(item.matches("(0[1-9]|[12][0-9]|3[01])[-.](0[1-9]|1[012])[-.](19|20)\\d\\d")) {
                return item;
            }
        }
        return null;
    }

    public String getTelephoneNumber(String[] array) {
        for (String item : array) {
            if(item.matches("\\d{5,11}")) {
                return item;
            }
        }
        return null;
    }

    public String getGender(String[] array) {
        for (String item : array) {
            if(item.matches("[fm]")) {
                return item;
            }
        }
        return  null;
    }
    
    public String getName(String[] array) {
        for (String item : array) {
            if(item.matches("[А-Яа-я]+") &&
                !item.equals(getSurname(array)) && 
                !item.equals(getPatronymic(array))) {
                    return item;
            }
        }
        return null;
     } 
}
