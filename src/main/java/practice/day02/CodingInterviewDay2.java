package practice.day02;

import org.dto.Payment;
import org.util.Utilities;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodingInterviewDay2 {

    public static void main(String args[])

    {
        Payment p2 = new Payment( "P2","456",5000.00, Utilities.PaymentStatus.FAILED, Utilities.PaymentMethod.UPI);
        Payment p3 = new Payment( "P3","789",2000.00,Utilities.PaymentStatus.FAILED, Utilities.PaymentMethod.CARD);
        Payment p5 = new Payment( "P5","900",2400.00,Utilities.PaymentStatus.PENDING, Utilities.PaymentMethod.UPI);
        Payment p6 = new Payment( "P6","345",4700.00,Utilities.PaymentStatus.PENDING, Utilities.PaymentMethod.BANK_TRANSFER);
        Payment p7 = new Payment( "P7","543",3800.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.BANK_TRANSFER);
        Payment p4 = new Payment( "P4","890",3000.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);
        Payment p1 = new Payment( "P1","123",1000.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);

        List <Payment> payments = List.of(p1,p2,p3,p4,p5,p6,p7);
        
        System.out.println("Payments:" + payments);
        //Given a list of payments, give me the total amount for each payment status
        Map<Utilities.PaymentStatus, Double> dashboard = payments.stream()
                .collect(Collectors.groupingBy(Payment::getStatus,Collectors.summingDouble(Payment::getAmount)));
                //.collect
                //(Collectors.groupingBy(Payment::getStatus,Collectors.summingDouble(Payment::getAmount)));
        System.out.println("dashboard:" + dashboard);

        Map<Utilities.PaymentStatus, Long> dashboard2 = payments.stream().collect
                (Collectors.groupingBy(Payment::getStatus,Collectors.counting()));
        System.out.println("dashboard2:" + dashboard2);




        Map<Utilities.PaymentStatus , DoubleSummaryStatistics> dashboard3 = payments.stream().collect
                (Collectors.groupingBy(Payment::getStatus, Collectors.summarizingDouble(Payment::getAmount)));
                //(Collectors.groupingBy(Payment::getStatus,Collectors.counting()));
        System.out.println("dashboard3:" + dashboard3);

 Map<Utilities.PaymentMethod,Long> groupingByPaymentMethod =  payments.stream().collect(Collectors.groupingBy(Payment::getPaymentMethod,Collectors.counting()));
        System.out.println("groupingByPaymentMethod:"+groupingByPaymentMethod);
    }




}
