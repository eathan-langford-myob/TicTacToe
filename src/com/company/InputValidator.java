package com.company;

class InputValidator {

    public static boolean isValidFormatWithDigits(String input){
        if(input.contains(",") && input.length() == 3){
            return input.replace(",","").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean isValidInputWithinBoard(String input, Board board) {
        String[] arrayFromSplitInput = input.split(",");
        if( (arrayFromSplitInput[0].length() == arrayFromSplitInput[1].length() && arrayFromSplitInput[0].length() < board.getBoard().length) ){

        }
    return false;
    }
}
