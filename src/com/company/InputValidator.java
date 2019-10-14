package com.company;

class InputValidator {

    public static boolean isValidFormatWithDigits(String input){
        if(input.contains(",") && input.length() == 3){
            return input.replace(",","").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean isValidInputWithinBoardRange(String input, int boardBounds) {
        String[] stringArrayOfInput = input.split(",");
        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[0] = Integer.parseInt(stringArrayOfInput[0]);
        arrayFromSplitInput[1] = Integer.parseInt(stringArrayOfInput[1]);
        if ( (arrayFromSplitInput[0] <= boardBounds) && (arrayFromSplitInput[1] <= boardBounds) && (stringArrayOfInput[0].length() == stringArrayOfInput[1].length())){
            return true;
        }
    return false;
    }
}
