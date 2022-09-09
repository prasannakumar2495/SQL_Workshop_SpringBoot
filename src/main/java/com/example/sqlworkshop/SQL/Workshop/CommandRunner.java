package com.example.sqlworkshop.SQL.Workshop;

import com.example.sqlworkshop.SQL.Workshop.controller.WorkShopController;
import com.example.sqlworkshop.SQL.Workshop.models.*;
import com.example.sqlworkshop.SQL.Workshop.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    private LoanTypeRepository loanTypeRepository;

    @Autowired
    WorkShopController workShopController;

    @Autowired
    private PaymentModeRepository paymentModeRepository;
    @Autowired
    private QueryTypeRepository queryTypeRepository;
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private PartnerCustomerRepository partnerCustomerRepository;
    @Autowired
    private PenaltyTypeRepository penaltyTypeRepository;
    @Autowired
    private EMIRepository emiRepository;
    @Autowired
    private LoanOutletRepository loanOutletRepository;
    @Autowired
    private BankDetailsRepository bankDetailsRepository;
    @Autowired
    private PaymentsRepository paymentsRepository;
    @Autowired
    private PenaltyRepository penaltyRepository;
    @Autowired
    private CallCentersRepository callCentersRepository;


    Calendar calendar = Calendar.getInstance();
    String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    long longNumber = new Random().nextLong(666666666, 999999999);
    long floatNumber = (long) new Random().nextFloat(1, 10);

    @Override
    public void run(String... args) throws Exception {
        long i;
        for (i = 1; i <= 600000; i++) {
            //createQueries();
        }
    }

    private void createQueries() {
        QueriesNewTable queriesNewTable = new QueriesNewTable(randomQueryStatus());
        workShopController.postQueries(1807450, 7322, queriesNewTable);
    }

    private void createCalls() {
        CallsNewTable callsNewTable = new CallsNewTable
                (String.valueOf(calendar.getTime()),
                        String.valueOf(calendar.getTime()));
        workShopController.postCalls(7341, 1807409, 1807418,
                callsNewTable);
    }

    private void createEmployees() {
        Employees employees = new Employees(generateRandom(aToZ));
        workShopController.postEmployees(1807409, employees);
    }

    private void createCallCenters() {
        CallCenters callCenters = new CallCenters(generateRandom(aToZ));
        callCentersRepository.save(callCenters);
    }

    private void createPenalty() {
        PenaltyNewTable penaltyNewTable = new PenaltyNewTable(generateRandom(aToZ), longNumber);
        workShopController.postPenaltyNewTable(107347, 107346, penaltyNewTable);
    }

    private void createPayments() {
        Payments payments = new Payments(generateRandom(aToZ), longNumber, String.valueOf(calendar.getTime()),
                randomPaymentStatus(), randomPaymentTypeMode());
        workShopController.postPayments(7316, 107347, 807396, payments);
    }

    private void createLoanOutlet() {
        LoanOutlet loanOutlet = new LoanOutlet(generateRandom(aToZ), generateRandom(aToZ));
        loanOutletRepository.save(loanOutlet);
    }

    private void createBankAccount() {
        BankDetailsNewTable bankDetailsNewTable = new BankDetailsNewTable(generateRandom(aToZ), generateRandom(aToZ), generateRandom(aToZ));
        bankDetailsRepository.save(bankDetailsNewTable);
    }

    private void createEMI() {
        EMINewTable emiNewTable = new EMINewTable(longNumber, String.valueOf(calendar.getTime()));
        emiRepository.save(emiNewTable);
    }

    private void createPenaltyType() {
        PenaltyTypeNewTable penaltyTypeNewTable = new PenaltyTypeNewTable("Late Pay", longNumber, 5);
        penaltyTypeRepository.save(penaltyTypeNewTable);
    }

    private void createPartnerCustomer() {
        PartnerCustomerNewTable partnerCustomerNewTable = new PartnerCustomerNewTable(generateRandom(aToZ));
        partnerCustomerRepository.save(partnerCustomerNewTable);
    }

    private void createCustomers() {
        Customers customers = new Customers(generateRandom(aToZ), generateRandom(aToZ), String.valueOf(longNumber), String.valueOf(longNumber), generateRandom(aToZ), generateRandom(aToZ), generateRandom(aToZ), generateRandom(aToZ), generateRandom(aToZ), generateRandom(aToZ));
        customersRepository.save(customers);
    }

    private void createQueryType() {
        QueryType queryType = new QueryType(generateRandom(aToZ));
        queryTypeRepository.save(queryType);
    }

    private void createPaymentMode() {
        PaymentModeNewTable paymentModeNewTable1 = new PaymentModeNewTable("Online");
        PaymentModeNewTable paymentModeNewTable2 = new PaymentModeNewTable("Cash");
        PaymentModeNewTable paymentModeNewTable3 = new PaymentModeNewTable("UPI");

        paymentModeRepository.save(paymentModeNewTable1);
        paymentModeRepository.save(paymentModeNewTable2);
        paymentModeRepository.save(paymentModeNewTable3);
    }

    private void createLoan(String loanStatus) {
        LoansNewTable loansNewTable = new LoansNewTable(loanStatus, 1000000, 1000000, randomBoolean(), randomBoolean(), String.valueOf(calendar.getTime()));
        workShopController.postLoans(7312, 7346, 107347, 107387, 107352, 107343, loansNewTable);
    }

    private void createLoanType() {
        LoanTypeNewTable loanTypeNewTable = new LoanTypeNewTable("Automobile", 5);
        loanTypeRepository.save(loanTypeNewTable);
        LoanTypeNewTable loanTypeNewTable2 = new LoanTypeNewTable("House", 10);
        loanTypeRepository.save(loanTypeNewTable2);
        LoanTypeNewTable loanTypeNewTable3 = new LoanTypeNewTable("Personal", 15);
        loanTypeRepository.save(loanTypeNewTable3);
        LoanTypeNewTable loanTypeNewTable4 = new LoanTypeNewTable("Education", 20);
        loanTypeRepository.save(loanTypeNewTable4);
        LoanTypeNewTable loanTypeNewTable5 = new LoanTypeNewTable("Electronic", 25);
        loanTypeRepository.save(loanTypeNewTable5);
    }

    private static String generateRandom(String aToZ) {
        Random rand = new Random();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int randIndex = rand.nextInt(aToZ.length());
            res.append(aToZ.charAt(randIndex));
        }
        return res.toString();
    }

    private static String randomPaymentStatus() {
        String[] paymentStatus = {"Success", "Failed", "Pending"};
        Random ran = new Random();
        return paymentStatus[ran.nextInt(paymentStatus.length)];
    }

    private static String randomPaymentTypeMode() {
        String[] paymentType = {"Online", "Cash"};
        Random ran = new Random();
        return paymentType[ran.nextInt(paymentType.length)];
    }

    private static String randomQueryStatus() {
        String[] paymentType = {"Resolved", "Closed", "Pending"};
        Random ran = new Random();
        return paymentType[ran.nextInt(paymentType.length)];
    }

    private static Boolean randomBoolean() {
        Random ran = new Random();
        return ran.nextBoolean();
    }

}
