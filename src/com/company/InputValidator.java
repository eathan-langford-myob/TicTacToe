package com.company;

class InputValidator {

    public static boolean isValidFormatWithDigits(String input){
        if(input.contains(",") && input.length() == 3){
            return input.replace(",","").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean isValidInputWithinBoardRange(String input, int boardLength) {
        int boardBounds = boardLength-1;
        String[] stringArrayOfInput = input.split(",");
        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[0] = Integer.parseInt(stringArrayOfInput[0]);
        arrayFromSplitInput[1] = Integer.parseInt(stringArrayOfInput[1]);
        return (arrayFromSplitInput[0] <= boardBounds) && (arrayFromSplitInput[1] <= boardBounds) && (stringArrayOfInput[0].length() == stringArrayOfInput[1].length());
    }

    public static Coordinates splitIntoCoordinate(String input) {
        String[] splitString = input.split(",");
        int[] intArrayFromInput = new int[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            intArrayFromInput[i] = Integer.parseInt(splitString[i]);
        }
        return new Coordinates(intArrayFromInput[0], intArrayFromInput[1]);
    }
}
