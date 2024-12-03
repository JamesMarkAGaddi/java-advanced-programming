package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ChekcStr {

    private static final Logger logger = LogManager.getLogger("ChekcStr");

    public ChekcStr() {
        logger.info("ChekcStr instantiated");
    }

    public String convert(String str) throws InvalidStringException {
        logger.info("Starting execution of convert() with input: {}", str);
        
        if (str == null || str.isEmpty()) {
            logger.error("Invalid input provided: null or empty string");
            throw new InvalidStringException("Input string cannot be null or empty");
        }

        int totalValue = total(str);
        String result = binarise(totalValue);

        logger.info("convert() returned: {}", result);
        logger.info("Ending execution of convert()");
        return result;
    }

    public int total(String str) {
        logger.info("Starting execution of total() with input: {}", str);

        int result;
        if (str.isEmpty()) {
            result = 0;
        } else if (str.length() == 1) {
            result = str.charAt(0);
        } else {
            result = str.charAt(0) + total(str.substring(1));
        }

        logger.info("total() returned: {}", result);
        logger.info("Ending execution of total()");
        return result;
    }

    public String binarise(int givenstrvalue) {
        logger.info("Starting execution of binarise() with input: {}", givenstrvalue);
        
        if (givenstrvalue == 0) {
            logger.info("binarise() returned base case: 0");
            return "0";
        }

        StringBuilder binaryString = new StringBuilder();

        while (givenstrvalue > 0) {
            binaryString.insert(0, givenstrvalue % 2); 
            givenstrvalue = givenstrvalue / 2;
        }

        String result = binaryString.toString();
        logger.info("binarise() returned: {}", result);
        logger.info("Ending execution of binarise()");
        return result;
    }
    
}
