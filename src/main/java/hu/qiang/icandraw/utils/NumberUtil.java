/**
 *
 */
package hu.qiang.icandraw.utils;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;

import java.util.Arrays;

/**
 * @author huqiang
 *
 */
public class NumberUtil {

    /**
     * @param numbers
     * @return true if all numbers are positive OR empty numbers are passed in.
     */
    public static boolean isAllPositiveNumbers(int... numbers) {
        return Arrays.stream(numbers).allMatch(n -> n > 0);
    }

    public static int stringToPositiveInt(String input)
            throws InvalidCommandParamException {
        try {
            int val = Integer.parseInt(input);
            if (val <= 0) {
                throw new InvalidCommandParamException("Expecting positive int");
            }
            return val;
        } catch (NumberFormatException e) {
            throw new InvalidCommandParamException("Expecting positive int");
        }
    }
}
