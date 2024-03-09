package org.henry;

public class Main {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,1,2,0,1}));
        System.out.println(maxProfit(new int[]{2,4,1}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        // day by day
        for (int i = 0; i < prices.length; i++) {
            // find the min stock
            int minStockIndex = i;
            for (int j = i; j < prices.length; j++) {
                if (prices[j] < prices[minStockIndex] && j != prices.length - 1 && prices[j] != 0) {
                    minStockIndex = j;
                }
            }

            // find max stock after min
            int maxStockIndex = minStockIndex;
            for (int j = minStockIndex; j < prices.length; j++) {
                if (prices[j] > prices[maxStockIndex]) {
                    maxStockIndex = j;
                    boolean another = false;
                    for (int k = j; k < prices.length; k++) {
                        if (prices[j] > prices[k]) {
                            another = true;
                            break;
                        }
                    }
                    if (another) break;
                }
            }

            // if max is the min skip
            if (minStockIndex != maxStockIndex) maxProfit += prices[maxStockIndex] - prices[minStockIndex];
            i = maxStockIndex;
        }


        return maxProfit;
    }
}
