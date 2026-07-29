package practice.day01;

import org.dto.Stock;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CodingInterviewDay1 {

public static void main(String args[])
{
    //create stock objects
    Stock apple = new Stock("AAPL","Apple","Technology", 30.0);
    Stock microsoft = new Stock("MSFT","Microsoft","Technology", 25.0);
    Stock tesla = new Stock("TSLA","Tesla","Automotive", 20.0);
    Stock nvidia = new Stock("NVDA","Nvidia","Technology", 15.0);
    Stock google = new Stock("GOOG","Google","Technology", 10.0);

    List<Stock> stocks = List.of(google,apple,microsoft,tesla,nvidia);
    System.out.println("Stocks:"+stocks);
    //System.out.println("attempt to print:");
    List<String> symbols =  stocks.stream()
            .filter( s->"Technology".equals(s.getSector()))
            .sorted(Comparator.comparing(Stock::getAllocation)
                    .reversed()).limit(3).map(Stock::getSymbol).toList();
    System.out.println("Symbols:"+symbols);

    //First, we filter "Technology" stock using Streams.filte()
    //
    List<String> top3TechStocks = stocks.stream()
            .filter(s -> "Technology".equals(s.getSector()))
            .filter(s -> s.getAllocation()>20)   //Get stocks that are > than 20% allocation
            .sorted(Comparator.comparing(Stock::getAllocation).reversed())
            .limit(3)
            .map(Stock::getSymbol)
            .toList();

    System.out.println("Results:"+top3TechStocks);

    stocks.stream()
            .filter(s -> "Technology".equals(s.getSector()))
           //.filter(s -> s.getAllocation()>20)
            .sorted(Comparator.comparing(Stock::getAllocation).reversed())
           // .limit(3)
            .forEach(System.out::println);




















    //Retyping the answer to build muscle memory :)
    // We have a list of stocks with sector and allocation %.
    // The requirement is to filter 'technology' stock with more than 20% allocation
    //Give me the Top 3 highest allocations.  Return only the symbols of the stock

    List <String> result = stocks.stream()
            .filter( s -> "Technology".equals(s.getSector()) &&
            s.getAllocation() > 20)
            .sorted(Comparator.comparing(Stock::getAllocation).reversed())
            .limit(3)
            .map(Stock::getSymbol)
            .toList();
    System.out.println("Result Again:" + result);

    List <String> a = stocks.stream()
            .filter( s -> "Technology".equals(s.getSector()) &&
                    s.getAllocation() > 20)
            .sorted(Comparator.comparing(Stock::getAllocation).reversed())
            .limit(3)
            .map(Stock::getSymbol)
            .toList();





}

}
