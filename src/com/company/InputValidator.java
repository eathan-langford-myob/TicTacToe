package com.company;

class InputValidator {

    public static boolean isValidFormatWithDigits(String input){
        if(input.contains(",") && input.length() == 3 && !input.contains("0")){
            return input.replace(",","").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean isValidInputWithinBoardRange(String input, int boardLength) {
        int boardBounds = boardLength;
        String[] stringArrayOfInput = input.split(",");
        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[0] = Integer.parseInt(stringArrayOfInput[0]);
        arrayFromSplitInput[1] = Integer.parseInt(stringArrayOfInput[1]);
        return (arrayFromSplitInput[0] <= boardBounds) && (arrayFromSplitInput[1] <= boardBounds) && (stringArrayOfInput[0].length() == stringArrayOfInput[1].length());
    }

    public static boolean isQuitKeyword(String input) {
        return input.toLowerCase().contains("q");
    }

    public static Coordinates splitIntoCoordinate(String input) {
        String[] splitString = input.split(",");
        return new Coordinates(Integer.parseInt(splitString[0])-1, Integer.parseInt(splitString[1])-1);
    }
}
