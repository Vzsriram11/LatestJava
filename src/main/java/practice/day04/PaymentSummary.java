package practice.day04;

import org.dto.CustomerPaymentSummary;
import org.dto.Payment;
import org.util.Utilities;

import java.util.*;
import java.util.stream.Collectors;

public class PaymentSummary {

    public static void main(String args[])
    {
        Payment p1 = new Payment( "P1","123",1000.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);
        Payment p1a = new Payment( "P1a","123",1500.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);

        Payment p2 = new Payment( "P2","456",5000.00, Utilities.PaymentStatus.FAILED, Utilities.PaymentMethod.CARD);
        Payment p2a = new Payment( "P2a","456",3500.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);

        Payment p3 = new Payment( "P3","789",2000.00,Utilities.PaymentStatus.FAILED, Utilities.PaymentMethod.CARD);
        Payment p3a = new Payment( "P3a","789",4500.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);

        Payment p4 = new Payment( "P4","890",3000.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);
        Payment p4a = new Payment( "P4a","890",2000.00,Utilities.PaymentStatus.FAILED, Utilities.PaymentMethod.CARD);


        Payment p5 = new Payment( "P5","900",2400.00,Utilities.PaymentStatus.PENDING, Utilities.PaymentMethod.UPI);
        Payment p5a = new Payment( "P5a","900",2000.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);

        Payment p6 = new Payment( "P6","345",4700.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.CARD);
        Payment p6a = new Payment( "P6a","345",1200.00,Utilities.PaymentStatus.PENDING, Utilities.PaymentMethod.CARD);

        Payment p7 = new Payment( "P7","543",3800.00,Utilities.PaymentStatus.SUCCESS, Utilities.PaymentMethod.BANK_TRANSFER);
        Payment p7a = new Payment( "P7a","543",4700.00,Utilities.PaymentStatus.PENDING, Utilities.PaymentMethod.CARD);

        List <Payment> payments = List.of(p1,p1a,p2,p2a,p3,p3a,p4,p4a,p5,p5a,p6,p6a,p7,p7a);

        System.out.println("Payments:" + payments);
        PaymentSummary ps = new PaymentSummary();
        System.out.println("Payments.summarize():" + ps.summarize(payments));

    }
    public List<CustomerPaymentSummary> summarize(List<Payment> payments)
    {
        Map<String, CustomerPaymentSummary> customerPaymentSummaryMap = new HashMap<>();
        if(payments != null && !payments.isEmpty())
        {
            for (Payment payment: payments)
            {
                if(payment != null && Utilities.PaymentStatus.SUCCESS.equals(payment.getStatus()))
                {
                    if(payment.getAmount() >0) {

                        CustomerPaymentSummary summary = customerPaymentSummaryMap.computeIfAbsent(
                                payment.getCustomerId(),
                                id -> {
                                    CustomerPaymentSummary s = new CustomerPaymentSummary();
                                    s.setCustomerId(id);
                                    return  s;
                                });

                        summary.setTotalAmount(summary.getTotalAmount()+payment.getAmount());
                        summary.setSuccessfulPayments(summary.getSuccessfulPayments()+1);
                    }else throw  new IllegalArgumentException("Amount can't be zero or less");

                }

            }
            //System.out.println("customerPaymentSummaryMap:"+customerPaymentSummaryMap);
        }

        return new ArrayList<>(customerPaymentSummaryMap.values());
           // return null;
    }

}
