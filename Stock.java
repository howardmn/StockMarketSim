// Holds a stock symbol and price for the stock engine.
public class Stock {
    // Instance variables.
    String stockSymbol;
    int pricePerShare;
    boolean lastMoveUp;

    Stock(String sStockSymbol, int iPricePerShare, boolean bLastMoveUp)
    {
        stockSymbol = sStockSymbol;
        pricePerShare = iPricePerShare;
        lastMoveUp = bLastMoveUp;
    }

}
