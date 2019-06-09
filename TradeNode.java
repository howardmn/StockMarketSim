// Holds details of a pending stock trade and is stored in a queue until execution.
public class TradeNode {
    // Instance variables.
    String stockSymbol;
    int shareCount;
    boolean buy;
    TradeNode nextTradeNode = null;
}
