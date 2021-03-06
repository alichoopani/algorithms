class StringCalculatorOne {

    public static void main(String... args) throws Exception {

        String str = "1-(-215*-2)/(20-(3/4)+2)";

        try {
            System.out.println(calculate(str));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static Integer calculate(String str) throws Exception {
        return Integer.valueOf(navigateOnString(str, 0));
    }

    public static String navigateOnString(String str, Integer index) throws Exception {
        System.out.println(str);
        if (index == str.length())
            return calcSecondPriorityOperations(calcFirstPriorityOperations(str, 0), 0);
        if (str.charAt(index) == ')') {
            Integer braceStartPosition = getFirstOpenBraceFromPosition(str, index);
            Integer x = calcStrWithoutBrace(str.substring(braceStartPosition + 1, index), 0);
            return navigateOnString(str.substring(0, braceStartPosition) + x + str.substring(++index), ++braceStartPosition);
        } else
            return navigateOnString(str, ++index);
    }

    public static Integer getFirstOpenBraceFromPosition(String str, Integer position) {
        return str.charAt(position) == '(' ? position : getFirstOpenBraceFromPosition(str, --position);
    }

    public static Integer calcStrWithoutBrace(String str, Integer index) throws Exception {
        return Integer.valueOf(calcSecondPriorityOperations(calcFirstPriorityOperations(str, 0), 0));
    }

    public static Integer getPreviousNumberInStringFromPosition(String str, Integer position, Integer length) {
        if (position.equals(length))
            return Integer.valueOf(str.substring(0, position));
        return (!Character.isDigit(str.charAt(position - length)))
                ? (str.charAt(position - length - 1) == '-')
                ? Integer.valueOf("-" + str.substring(position - length + 1, position))
                : Integer.valueOf(str.substring(position - length + 1, position))
                : getPreviousNumberInStringFromPosition(str, position, ++length);
    }

    public static Integer getNextNumberInStringFromPosition(String str, Integer position, Integer length) {
        if (position + length == str.length())
            return Integer.valueOf(str.substring(position + 1));
        return (!Character.isDigit(str.charAt(position + length)))
                ? (length == 1 && str.charAt(position + length) == '-')
                ? -getNextNumberInStringFromPosition(str, ++position, 1)
                : Integer.parseInt(str.substring(position + 1, position + length))
                : getNextNumberInStringFromPosition(str, position, ++length);
    }

    public static String calcFirstPriorityOperations(String str, Integer index) throws Exception {
        if (index == str.length())
            return str;
        char c = str.charAt(index);
        int result;
        if (index == 0 && c == '-' || c == '+')
            return calcFirstPriorityOperations(str, ++index);
        if (c == '*' || c == '/') {
            Integer previousNumber = getPreviousNumberInStringFromPosition(str, index, 1);
            Integer nextNumber = getNextNumberInStringFromPosition(str, index, 1);
            //TODO dividing by 0 !!!
            if (nextNumber == 0 && c == '/')
                throw new Exception("!divided by zero!");
            result = (c == '*') ? previousNumber * nextNumber : previousNumber / nextNumber;
            return calcFirstPriorityOperations(
                    str.substring(
                            0,
                            index - getCountOfDigits(previousNumber, 0)
                    ) + result + str.substring(index + getCountOfDigits(nextNumber, 0) + 1),
                    index - getCountOfDigits(previousNumber, 0));
        } else
            return calcFirstPriorityOperations(str, ++index);
    }

    public static String calcSecondPriorityOperations(String str, Integer index) {
        if (index == str.length())
            return str;
        char c = str.charAt(index);
        int result;
        if (c == '+' || c == '-') {
            if (index == 0)
                return calcSecondPriorityOperations(str, ++index);

            Integer previousNumber = getPreviousNumberInStringFromPosition(str, index, 1);
            Integer nextNumber = getNextNumberInStringFromPosition(str, index, 1);
            result = (c == '+') ? previousNumber + nextNumber : previousNumber - nextNumber;
            return calcSecondPriorityOperations(
                    str.substring(0, index - getCountOfDigits(previousNumber, 0))
                            + result
                            + str.substring(index + getCountOfDigits(nextNumber, 0) + 1),
                    index - getCountOfDigits(previousNumber, 0));
        } else
            return calcSecondPriorityOperations(str, ++index);
    }

    public static Integer getCountOfDigits(Integer num, Integer index) {
        if (num == 0)
            return 1;
        if (num / (int) Math.pow(10, index + 1) > 0)
            return getCountOfDigits(num, ++index);
        if (num < 0)
            return getCountOfDigits(-num * 10, 0);
        return ++index;
    }

}
