import java.util.Random;

public class StockEngine {

    // Constructor.
    public StockEngine() {
        rand = new Random();
        // Initialize 4 stock objects with stock symbols and use rand object to generate beginning prices.
        stocks = new Stock[4];
        stocks[0] = new Stock("Samsung", rand.nextInt(100), rand.nextBoolean());
        stocks[1] = new Stock("Apple", rand.nextInt(100), rand.nextBoolean());
        stocks[2] = new Stock("LG", rand.nextInt(100), rand.nextBoolean());
        stocks[3] = new Stock("HTC", rand.nextInt(100), rand.nextBoolean());
    }

    // Instance variables.
    Random rand;
    Stock[] stocks;

    // Methods.
    // Goes through each stock in the array and adjusts the price due to a random # algo.
    public void cycleTurn() {
        int stockMoveLimit = 4;
        int stockMove = 0;
        int trendChance = 100;

        // Adjusts the up and down of price.
        for(Stock oStock : stocks) {
            stockMove = rand.nextInt(stockMoveLimit);

            if(rand.nextInt(100) < trendChance) {
                if(oStock.lastMoveUp) {
                    oStock.pricePerShare += stockMove;
                } else {
                    if(oStock.pricePerShare - stockMove < 0) {
                        oStock.pricePerShare = 0;
                    } else {
                        oStock.pricePerShare -= stockMove;
                    }
                }
            }

            else {
                if(oStock.lastMoveUp) {
                    if(oStock.pricePerShare - stockMove < 0) {
                        oStock.pricePerShare = 0;
                    } else {
                        oStock.pricePerShare -= stockMove;
                    }
                } else {
                    oStock.pricePerShare += stockMove;
                }
            }

            System.out.println(oStock.stockSymbol + " stock is now $" + oStock.pricePerShare + " per share.");
        }
        System.out.println();
    }
}


