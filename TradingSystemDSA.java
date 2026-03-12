import java.util.*;

// Stock Class
class Stock {
    String name;
    double price;

    Stock(String name,double price){
        this.name=name;
        this.price=price;
    }

    void display(){
        System.out.println(name+" | "+price);
    }
}

public class TradingSystemDSA {

    // CO-1 Linear Search
    static void linearSearch(List<Stock> stocks,String key){

        for(Stock s:stocks){
            if(s.name.equalsIgnoreCase(key)){
                System.out.println("Stock Found: "+s.name+" Price:"+s.price);
                return;
            }
        }

        System.out.println("Stock Not Found");
    }

    // CO-1 Bubble Sort
    static void bubbleSort(List<Stock> stocks){

        for(int i=0;i<stocks.size()-1;i++){

            for(int j=0;j<stocks.size()-i-1;j++){

                if(stocks.get(j).price > stocks.get(j+1).price){

                    Stock temp = stocks.get(j);
                    stocks.set(j,stocks.get(j+1));
                    stocks.set(j+1,temp);

                }
            }
        }

        System.out.println("Stocks Sorted by Price:");
        for(Stock s:stocks)
            s.display();
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        // Stock List (CO-2 List ADT)
        List<Stock> stocks=new LinkedList<>();

        stocks.add(new Stock("AAPL",175));
        stocks.add(new Stock("TSLA",240));
        stocks.add(new Stock("BTC",65000));
        stocks.add(new Stock("ETH",3200));

        // CO-3 Queue (Ticker)
        Queue<Stock> ticker=new LinkedList<>();

        ticker.addAll(stocks);

        // CO-3 Stack (Trade History)
        Stack<String> history=new Stack<>();

        // CO-4 Hashing
        HashMap<String,Double> stockMap=new HashMap<>();

        for(Stock s:stocks)
            stockMap.put(s.name,s.price);

        while(true){

            System.out.println("\n===== TRADING MENU =====");
            System.out.println("1.Show Live Ticker");
            System.out.println("2.Search Stock");
            System.out.println("3.Sort Stocks");
            System.out.println("4.Buy Stock");
            System.out.println("5.Sell Stock");
            System.out.println("6.Trade History");
            System.out.println("7.Hash Search");
            System.out.println("8.Exit");

            int ch=sc.nextInt();

            switch(ch){

                case 1:

                    System.out.println("Live Stock Ticker");

                    for(int i=0;i<ticker.size();i++){

                        Stock s=ticker.poll();
                        s.display();
                        ticker.add(s);

                    }

                    break;

                case 2:

                    System.out.println("Enter stock name:");
                    String key=sc.next();

                    linearSearch(stocks,key);

                    break;

                case 3:

                    bubbleSort(stocks);

                    break;

                case 4:

                    System.out.println("Enter stock to BUY:");
                    String buy=sc.next();

                    history.push("BUY "+buy);

                    System.out.println("Stock Bought");

                    break;

                case 5:

                    System.out.println("Enter stock to SELL:");
                    String sell=sc.next();

                    history.push("SELL "+sell);

                    System.out.println("Stock Sold");

                    break;

                case 6:

                    System.out.println("Trade History:");

                    for(String h:history)
                        System.out.println(h);

                    break;

                case 7:

                    System.out.println("Enter stock for Hash Search:");
                    String s=sc.next();

                    if(stockMap.containsKey(s))
                        System.out.println("Price:"+stockMap.get(s));
                    else
                        System.out.println("Stock not found");

                    break;

                case 8:

                    System.exit(0);

            }

        }

    }

}