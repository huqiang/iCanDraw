/**
 *
 */
package hu.qiang.icandraw.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;

/**
 * @author huqiang
 *
 */
public class Validator {
	public static void shouldAllPositiveNumbers(int... numbers) {
		if(!NumberUtil.isAllPositiveNumbers(numbers)) {
			throw new InvalidCommandParamException(String.format("Expecting all positive int, given: %s",
					Arrays.stream(numbers)
						.mapToObj(Integer::toString)
						.collect(Collectors.joining(", "))));
		}
	}
}
