// Manages the pending trade nodes in a queue for the StockMarketSim class.
public class TradeQueue {
    // Instance variables.
    TradeNode headTradeNode = null;
    TradeNode tailTradeNode = null;

    // Methods
    // Enqueue - adds TradeNode to end of queue.
    public void enqueue(String sStockSymbol, int iPurchaseShareCount, boolean bBuy) {
        // Create new TradeNode.
        TradeNode newTradeNode = new TradeNode();
        // Set instance var. from TradeNode to object.
        newTradeNode.stockSymbol = sStockSymbol;
        newTradeNode.shareCount = iPurchaseShareCount;
        newTradeNode.buy = bBuy;

        if(headTradeNode == null) {
            // Set both headTradeNode and tailTradeNode to new TradeNode.
            headTradeNode = newTradeNode;
            tailTradeNode = newTradeNode;
        } else {
            // Assign tailTradeNode's nextTradeNode variable to new TradeNode.
            tailTradeNode.nextTradeNode = newTradeNode;
            // Assign new TradeNode to the tailTradeNode variable.
            tailTradeNode = newTradeNode;
        }
    }
    // Dequeue - returns headTradeNode (next in line) and makes the second in the queue
    // now first in line.
    TradeNode dequeue() { // Note: void can't be returned.
        // If current headTradeNode is null, then return null.
        if (headTradeNode == null) {
            return null;
        } else {
            // Create temp. newTradeNode object.
            TradeNode tempNewTradeNode = new TradeNode();
            // Assign the current headTradeNode to temp.
            tempNewTradeNode = headTradeNode;
            // Assigns headTradeNode.nextTradeNode to headTradeNode.
            headTradeNode = headTradeNode.nextTradeNode;

            // Return it to method caller.
            return tempNewTradeNode;
        }
    }
}
