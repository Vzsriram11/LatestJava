package org.example;

import org.dto.Transaction;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FraudDetectionService {

    // 1. Define clean, isolated, testable predicates
    private static final Predicate<Transaction> isHighAmount =
            t -> t.getAmount() > 10000.0;

    private static final Predicate<Transaction> isPending =
            t -> "PENDING".equalsIgnoreCase(t.getStatus());

    private static final Predicate<Transaction> isHighRiskLocation =
            Transaction::isHighRiskLocation; // Method reference syntax



  /*  public Map<String,Double> countryDashboard(List<Transaction> transactions) {

    }*/


        public Map<String, Double> identifyHighRiskTransactions(List<Transaction> transactions) {
        // 2. Chained filters become a readable business sentence
        return transactions.stream()
                .filter(isHighAmount)
                .filter(isPending)
                .filter(isHighRiskLocation)
                .collect(Collectors.groupingBy(Transaction::getCountry,Collectors.summingDouble(Transaction::getAmount)));

    }
}
