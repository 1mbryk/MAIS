package service;

public class Validation {
    public boolean validateInputDate(String str){
        boolean flag = false;
        for (char i : str.toCharArray()) {
            if (Character.isDigit(i) ||
            i == ' ' || i == '-' || i == ',') {
                flag = true;
            }
            else{
                return false;
            }
        }
        return flag;
    }
}
