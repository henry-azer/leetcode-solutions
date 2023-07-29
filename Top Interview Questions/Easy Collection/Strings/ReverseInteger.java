package org.henry;

public class Main {

    public static void main(String[] args) {
        int number = -304200;
        System.out.println(reverse(number));
        System.out.println(reverse2(number));
    }

    public static int reverse(int x) {
        int k = x;
        long sum = 0;
        if (x < 0) k = (-1) * k;
        while (k > 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
            k = k / 10;
        }
        if (sum < Math.pow(-2, 31) || sum > Math.pow(2, 31)) return 0;
        else return (int) sum;
    }

    public static int reverse2(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        String value = String.valueOf(x);
        boolean isNegative = value.charAt(0) == '-';
        stringBuilder.append(value, isNegative ? 1 : 0, value.length()).reverse();
        try {
            return isNegative ? Integer.parseInt('-' + stringBuilder.toString()) : Integer.parseInt(stringBuilder.toString());
        } catch (NumberFormatException exception) {
            return 0;
        }
    }
}
