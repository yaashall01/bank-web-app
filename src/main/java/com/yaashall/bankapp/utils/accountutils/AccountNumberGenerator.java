package com.yaashall.bankapp.utils.accountutils;

/**
 *
 * @auther Yassine CHALH
 */

import java.security.SecureRandom;
import java.time.Year;
public class AccountNumberGenerator {


    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates an account number with a specified account type prefix.
     *
     * The format of the generated account number is as follows:
     * [Account Type Prefix][Last Two Digits of Current Year][Random Sequence][Check Digit]
     *
     * Example: For a savings account, the prefix might be "10". If the current year is 2023,
     * and the random sequence generated is 123456, with a check digit of 7, the account
     * number would be 10231234567.
     *
     * @param accountTypePrefix The prefix to denote the type of account (e.g., "10" for savings).
     * @return A string representing the generated account number.
     */
    public static String generateAccountNumber(String accountTypePrefix) {
        String yearPart = String.valueOf(Year.now().getValue()).substring(2);

        StringBuilder randomPart = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            randomPart.append(digit);
        }

        String accountNumberWithoutCheckDigit = accountTypePrefix + yearPart + randomPart;

        // Calculate the Luhn check digit and append it
        int checkDigit = calculateLuhnCheckDigit(accountNumberWithoutCheckDigit);

        return accountNumberWithoutCheckDigit + checkDigit;
    }

    /**
     * Calculates the Luhn check digit for a given number string.
     * This method implements the Luhn Algorithm to calculate the check digit.
     *
     * @param number The number string for which to calculate the Luhn check digit.
     * @return The calculated Luhn check digit.
     */
    private static int calculateLuhnCheckDigit(String number) {
        int sum = 0;
        boolean alternate = false;

        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        // Luhn check digit
        return (10 - (sum % 10)) % 10;
    }

}
