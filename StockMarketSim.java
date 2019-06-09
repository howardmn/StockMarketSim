import java.util.Scanner;

public class StockMarketSim {
    TradingAccount tradingAccount;
    TradeQueue tradeQueue;
    StockEngine stockEngine;

    // start Method
    public void start() {

        // Instantiate all instance variables.
        tradingAccount = new TradingAccount();
        tradingAccount.username = "Jim";
        tradingAccount.password = "J000m";
        tradingAccount.balance = 100000;

        tradeQueue = new TradeQueue();
        stockEngine = new StockEngine();

        tradingAccount.stockPositions = new StockPosition[4];
        tradingAccount.stockPositions[0] = new StockPosition();
        tradingAccount.stockPositions[1] = new StockPosition();
        tradingAccount.stockPositions[2] = new StockPosition();
        tradingAccount.stockPositions[3] = new StockPosition();

        tradingAccount.stockPositions[0].shareCount = 0;
        tradingAccount.stockPositions[1].shareCount = 0;
        tradingAccount.stockPositions[2].shareCount = 0;
        tradingAccount.stockPositions[3].shareCount = 0;

        tradingAccount.stockPositions[0].stockSymbol = "Samsung";
        tradingAccount.stockPositions[1].stockSymbol = "Apple";
        tradingAccount.stockPositions[2].stockSymbol = "LG";
        tradingAccount.stockPositions[3].stockSymbol = "HTC";


        // Call method.
        runUI();
    }

    // runUI method.
    public void runUI() {

        Scanner userInput = new Scanner(System.in);

        String userChoice;

        do {
            System.out.println("---------Menu---------");
            System.out.println("Press 1 for Account Information.");
            System.out.println("Press 2 to Trade Stocks.");
            System.out.println("Press 3 to Cycle Stock Market.");
            System.out.println("Type \"exit\" to exit the Menu.");

            userChoice = userInput.next();

            switch (userChoice)
            {
                case "1":

                    System.out.println("Username: " + tradingAccount.username);
                    System.out.println("Password: " + tradingAccount.password);
                    System.out.println("Balance: $" + tradingAccount.balance);

                    for (int x = 0; x < tradingAccount.stockPositions.length; x++) {
                        System.out.println(tradingAccount.stockPositions[x].stockSymbol + " = " +
                        tradingAccount.stockPositions[x].shareCount + " shares");
                    }

                    break;

                case "2":

                    System.out.println("Which stock do you want to buy/sell? (1 - Samsung, 2 - Apple, 3 - LG, 4 - HTC)");
                    userInput.nextInt();
                    System.out.println("How many shares?");
                    userInput.nextInt();
                    System.out.println("Do you want to buy or sell stock? (Type 1 to buy or 2 to sell)? ");
                    userInput.nextInt();
                    stockEngine.cycleTurn();
                    processTrades();

                    break;

                case "3":

                    stockEngine.cycleTurn();
                    processTrades();

                    break;

                case "exit":
                    break;

                default: System.out.println("Invalid selection.");
                    break;
            }
        } while (!userChoice.equals("exit") && tradingAccount.balance > 0);

        System.out.println("Final balance: " + tradingAccount.balance);
        System.out.println("Exiting...");
    }

    public void processTrades() {

        while (tradeQueue.headTradeNode != null) {
            for(int x=0; x < tradingAccount.stockPositions.length; x++) {

                if (tradeQueue.headTradeNode.stockSymbol == tradingAccount.stockPositions[x].stockSymbol) {
                    if (tradeQueue.headTradeNode.buy) {
                        tradingAccount.stockPositions[x].shareCount += tradeQueue.headTradeNode.shareCount;
                        tradingAccount.balance -= tradeQueue.headTradeNode.shareCount * stockEngine.stocks[x].pricePerShare;

                    } else {
                        tradingAccount.stockPositions[x].shareCount -= tradeQueue.headTradeNode.shareCount;
                        tradingAccount.balance += tradeQueue.headTradeNode.shareCount * stockEngine.stocks[x].pricePerShare;
                    }
                }

            }
            tradeQueue.dequeue();
        }
    }
}





