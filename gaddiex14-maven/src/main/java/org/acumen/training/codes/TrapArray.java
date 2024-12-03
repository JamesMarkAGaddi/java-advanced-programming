package org.acumen.training.codes;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrapArray {

	private static final Logger LOGGER = LogManager.getLogger("TrapArray");

	private int size = 0;
	private int[] array = null;

	public void arrayTransact() {
		Scanner scanner = new Scanner(System.in);
		try {
			LOGGER.info("TrapArray starts. ({})", java.time.LocalDate.now());
			inputSize(scanner);
			inputElements(scanner);
			viewElements(scanner);
		} catch (Exception e) {
			LOGGER.error("Exception occurred: ", e);
		} finally {
			scanner.close();
		}
	}

	private void inputSize(Scanner scanner) {
		while (true) {
			System.out.print("Enter the Array Size: ");
			String inputSize = scanner.nextLine();

			try {
				size = Integer.parseInt(checkInput(inputSize));
				checkSize(size);
				array = new int[size];
				LOGGER.info("Array of {} integers created. ({})", size, java.time.LocalDate.now());
				break;
			} catch (LetterSizeException e) {
				LOGGER.error("LetterSizeException: Invalid array size provided.");
				e.printStackTrace();
			} catch (NegativeArraySizeException e) {
				LOGGER.error("NegativeArraySizeException: Negative array size provided.");
				e.printStackTrace();
			} catch (NumberFormatException e) {
				LOGGER.error("NumberFormatException: Non-integer array size.");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("Unexpected error: ", e.getMessage());
			}
		}
	}

	private String checkInput(String inputSize) throws LetterSizeException, Exception {
		if (inputSize.matches("[a-zA-Z]+")) {
			throw new LetterSizeException();
		}

		Integer.parseInt(inputSize);
		return inputSize;
	}

	private int checkSize(int size) throws NegativeArraySizeException, Exception {
		if (size < 0) {
			throw new NegativeArraySizeException();
		}
		return 0;
	}

	private void inputElements(Scanner scanner) {
		for (int i = 0; i < size; i++) {
			while (true) {
				System.out.print("Enter the value: ");
				String inputElement = scanner.nextLine();

				try {
					checkElement(inputElement);
					checkString(inputElement);
					checkRealNums(inputElement);
					array[i] = Integer.parseInt(inputElement);
					break;
				} catch (ElementCharException | ElementDecimalException e) {
					e.printStackTrace();
					LOGGER.error("Invalid element: ", e.getMessage());
					e.printStackTrace();
				} catch (NumberFormatException e) {
					LOGGER.error("Non-integer element provided.");
					e.printStackTrace();
				} catch (Exception e) {
					LOGGER.error("Unexpected error: ", e.getMessage());
					e.printStackTrace();

				}
			}
		}
	}

	private void checkElement(String inputElement) throws ElementCharException, Exception {
		if (inputElement.matches("[a-zA-Z]")) {
			throw new ElementCharException();
		}
	}

	private void checkString(String inputElement) throws ElementStringException, Exception {
		if (inputElement.matches("[a-zA-Z]+")) {
			throw new ElementStringException();
		}
	}

	private void checkRealNums(String inputElement) throws ElementDecimalException, Exception {
		if (inputElement.matches("(\\d*\\.\\d*)+")) {
			throw new ElementDecimalException();
		}
	}

	private void viewElements(Scanner scanner) {
		while (true) {
			System.out.print("Enter the Index that you want to view: ");
			String inputIndex = scanner.nextLine();

			if (inputIndex.equalsIgnoreCase("E")) {
				System.out.println("Goodbye");
				break;
			}

			try {
				int index = Integer.parseInt(inputIndex);
				checkIndex(index);
				System.out.printf("The Value in index %d is %d%n", index, array[index]);
			} catch (BadIndexException e) {
				LOGGER.error("Bad index: ", e);
			} catch (NumberFormatException e) {
				LOGGER.error("Non-integer index provided.");
			} catch (Exception e) {
				LOGGER.error("Unexpected error: ", e);
			}
		}
	}

	private void checkIndex(int index) throws BadIndexException, Exception {
		if (index < 0 || index >= array.length) {
			throw new BadIndexException();
		}
	}
}
