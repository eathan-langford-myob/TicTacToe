package com.company;

class InputValidator {

    public static boolean isValidFormatWithDigits(String input){
        if(input.contains(",") && input.length() == 3){
            return input.replace(",","").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean isValidInputWithinBoard(String input, Board board) {
        return true;
    }
}
