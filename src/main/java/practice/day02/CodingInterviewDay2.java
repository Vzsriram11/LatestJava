package practice.day01;

import org.dto.Payment;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodingInterviewDay2 {

    public static void main(String args[])

    {
        Payment p2 = new Payment( "P2","456",5000.00,"FAILED", "CARD");
        Payment p3 = new Payment( "P3","789",2000.00,"FAILED", "CARD");
        Payment p5 = new Payment( "P5","900",2400.00,"PENDING", "CARD");
        Payment p6 = new Payment( "P6","345",4700.00,"PENDING", "CARD");
        Payment p7 = new Payment( "P7","543",3800.00,"SUCCESS", "UPI");
        Payment p4 = new Payment( "P4","890",3000.00,"SUCCESS", "CARD");
        Payment p1 = new Payment( "P1","123",1000.00,"SUCCESS", "CARD");

        List <Payment> payments = List.of(p1,p2,p3,p4,p5,p6,p7);
        
        System.out.println("Payments:" + payments);
        Map<String , Double> dashboard = payments.stream().collect
                (Collectors.groupingBy(Payment::getStatus,Collectors.summingDouble(Payment::getAmount)));
        System.out.println("dashboard:" + dashboard);

        Map<String , Long> dashboard2 = payments.stream().collect
                (Collectors.groupingBy(Payment::getStatus,Collectors.counting()));
        System.out.println("dashboard2:" + dashboard2);

        Map<String , DoubleSummaryStatistics> dashboard3 = payments.stream().collect
                (Collectors.groupingBy(Payment::getStatus, Collectors.summarizingDouble(Payment::getAmount)));
                //(Collectors.groupingBy(Payment::getStatus,Collectors.counting()));
        System.out.println("dashboard3:" + dashboard3);
        dashboard3.



    }




}
