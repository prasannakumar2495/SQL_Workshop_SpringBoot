package com.example.sqlworkshop.SQL.Workshop.controller;

import com.example.sqlworkshop.SQL.Workshop.models.*;
import com.example.sqlworkshop.SQL.Workshop.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkShopController {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private CallCentersRepository callCentersRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LoanOutletRepository loanOutletRepository;

    @Autowired
    private QueryTypeRepository queryTypeRepository;

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    @Autowired
    private CallsRepository callsRepository;

    @Autowired
    private EMIRepository emiRepository;

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private LoanTypeRepository loanTypeRepository;

    @Autowired
    private PartnerCustomerRepository partnerCustomerRepository;

    @Autowired
    private PaymentModeRepository paymentModeRepository;

    @Autowired
    private PenaltyTypeRepository penaltyTypeRepository;

    @Autowired
    private PenaltyRepository penaltyRepository;

    @GetMapping("/getcustomers")
    public List<Customers> getCustomer() {
        return customersRepository.findAll();
    }

    @PostMapping("/postcustomers")
    public String postCustomer(@RequestBody Customers customersList) {
        customersRepository.save(customersList);
        return "Data Added Successfully";
    }

    @GetMapping("/getpayments")
    public List<Payments> getPayments() {
        return paymentsRepository.findAll();
    }

    @PostMapping("/postpayments/{paymentModeId}/{emiId}/{penaltyId}")
    public String postPayments
            (@PathVariable long paymentModeId,
             @PathVariable long emiId,
             @PathVariable long penaltyId,
             @RequestBody Payments payments) {

        Optional<PaymentModeNewTable> paymentModeNewTableOptional = paymentModeRepository.findById(paymentModeId);
        Optional<EMINewTable> emiNewTableOptional = emiRepository.findById(emiId);
        Optional<PenaltyNewTable> penaltyNewTableOptional = penaltyRepository.findById(penaltyId);

        payments.setPaymentModeNewTable(paymentModeNewTableOptional.get());
        payments.setEmiNewTable(emiNewTableOptional.get());
        payments.setPenaltyNewTable(penaltyNewTableOptional.get());

        paymentsRepository.save(payments);
        return "Data Added Successfully";
    }

    @GetMapping("/getcallcenters")
    public List<CallCenters> getCallCenters() {
        return callCentersRepository.findAll();
    }

    @PostMapping("/postcallcenters")
    public String postCallCenters(@RequestBody CallCenters callCenters) {
        callCentersRepository.save(callCenters);
        return "Data Added Successfully";
    }

    @GetMapping("/getemployees")
    public List<Employees> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/postemployees/{callCenterId}")
    public String postEmployees(
            @PathVariable long callCenterId,
            @RequestBody Employees employees) {
        Optional<CallCenters> callCentersOptional = callCentersRepository.findById(callCenterId);

        employees.setCallCenters(callCentersOptional.get());

        employeeRepository.save(employees);
        return "Data Added Successfully";
    }

    @GetMapping("/getloanoutlet")
    public List<LoanOutlet> getLoanOutlet() {
        return loanOutletRepository.findAll();
    }

    @PostMapping("/postloanoutlet")
    public String postLoanOutlet(@RequestBody LoanOutlet loanOutlet) {
        loanOutletRepository.save(loanOutlet);
        return "Data Added Successfully";
    }

    @GetMapping("/getquerytypes")
    public List<QueryType> getQueryType() {
        return queryTypeRepository.findAll();
    }

    @PostMapping("/postquerytype")
    public String postQueryType(@RequestBody QueryType queryType) {
        queryTypeRepository.save(queryType);
        return "Data Added Successfully";
    }

    @GetMapping("/getqueries")
    public List<QueriesNewTable> getQueries() {
        return queryRepository.findAll();
    }

    @PostMapping("/postqueries/{callsId}/{queryTypeId}")
    public String postQueries(
            @PathVariable long callsId,
            @PathVariable long queryTypeId,
            @RequestBody QueriesNewTable queriesNewTable) {
        Optional<CallsNewTable> callsNewTableOptional = callsRepository.findById(callsId);
        Optional<QueryType> queryTypeOptional = queryTypeRepository.findById(queryTypeId);

        queriesNewTable.setQueryType(queryTypeOptional.get());
        queriesNewTable.setCallsNewTable(callsNewTableOptional.get());
        queryRepository.save(queriesNewTable);
        return "Data Added Successfully";
    }

    @GetMapping("/getbankdetails")
    public List<BankDetailsNewTable> getBankDetails() {
        return bankDetailsRepository.findAll();
    }

    @PostMapping("/postbankdetails")
    public String postBankDetails(@RequestBody BankDetailsNewTable bankDetailsNewTable) {
        bankDetailsRepository.save(bankDetailsNewTable);
        return "Data Added Successfully";
    }

    @GetMapping("/getcalls")
    public List<CallsNewTable> getCalls() {
        return callsRepository.findAll();
    }

    @PostMapping("/postcalls/{customerId}/{callCenterId}/{employeeId}")
    public String postCalls(
            @PathVariable int customerId,
            @PathVariable long callCenterId,
            @PathVariable long employeeId,
            @RequestBody CallsNewTable callsNewTable) {
        Optional<Customers> customersOptional = customersRepository.findById(customerId);
        Optional<CallCenters> callCentersOptional = callCentersRepository.findById(callCenterId);
        Optional<Employees> employees = employeeRepository.findById(employeeId);

        callsNewTable.setCustomersList(customersOptional.stream().toList());
        callsNewTable.setCallCenters(callCentersOptional.get());
        callsNewTable.setEmployees(employees.get());
        callsRepository.save(callsNewTable);
        return "Data Added Successfully";
    }

    @GetMapping("/getemi")
    public List<EMINewTable> getEMI() {
        return emiRepository.findAll();
    }

    @PostMapping("/postemi")
    public String postEMI(@RequestBody EMINewTable emiNewTable) {
        emiRepository.save(emiNewTable);
        return "Data Added Successfully";
    }

    @GetMapping("/getloans")
    public List<LoansNewTable> getLoans() {
        return loansRepository.findAll();
    }

    //    @PostMapping("/postloans")
//    public void postLoans(
//            @PathVariable String loanStatus,
//            @PathVariable long totalAmountPaid,
//            @PathVariable long totalLoanAmount,
//            @PathVariable Boolean autoDebit,
//            @PathVariable Boolean noc,
//            @PathVariable String dateOfSanction,
//            @PathVariable long loanTypeId,
//            @PathVariable long idCustomer,
//            @PathVariable long emiId,
//            @PathVariable long bankAccountNumber,
//            @PathVariable long loanOutletId,
//            @PathVariable long partnerCustomerId) {
//        loansRepository.postLoans(loanStatus,
//                totalAmountPaid,
//                totalLoanAmount,
//                autoDebit,
//                noc,
//                dateOfSanction,
//                loanTypeId,
//                idCustomer,
//                emiId,
//                bankAccountNumber,
//                loanOutletId,
//                partnerCustomerId);
//    }
    @PostMapping("/postloans/{loanTypeId}/{idCustomer}/{emiId}/{bankAccountNumber}/{loanOutletId}/{partnerCustomerId}")
    public String postLoans(@PathVariable long loanTypeId,
                            @PathVariable int idCustomer,
                            @PathVariable long emiId,
                            @PathVariable long bankAccountNumber,
                            @PathVariable long loanOutletId,
                            @PathVariable long partnerCustomerId,
                            @RequestBody LoansNewTable loansNewTable) {
        Optional<LoanTypeNewTable> loanTypeNewTable = loanTypeRepository.findById(loanTypeId);
        Optional<Customers> customers = customersRepository.findById(idCustomer);
        Optional<EMINewTable> emiNewTable = emiRepository.findById(emiId);
        Optional<BankDetailsNewTable> bankDetailsNewTable = bankDetailsRepository.findById(bankAccountNumber);
        Optional<LoanOutlet> loanOutlet = loanOutletRepository.findById(loanOutletId);
        Optional<PartnerCustomerNewTable> partnerCustomerNewTable = partnerCustomerRepository.findById(partnerCustomerId);

        loansNewTable.setLoanTypeNewTable(loanTypeNewTable.get());
        loansNewTable.setCustomers(customers.get());
        loansNewTable.setEmiNewTableList(emiNewTable.get());
        loansNewTable.setBankDetailsNewTable(bankDetailsNewTable.get());
        loansNewTable.setLoanOutlet(loanOutlet.get());
        loansNewTable.setPartnerCustomerNewTable(partnerCustomerNewTable.get());

        loansRepository.save(loansNewTable);

        return "Data inserted Successfully!";
    }

    @GetMapping("/getloantype")
    public List<LoanTypeNewTable> getLoanType() {
        return loanTypeRepository.findAll();
    }

    @PostMapping("/postloantype")
    public String postLoanType(@RequestBody LoanTypeNewTable loanTypeNewTable) {
        loanTypeRepository.save(loanTypeNewTable);
        return "Data Added Successfully";
    }

    @GetMapping("/getpartnercustomer")
    public List<PartnerCustomerNewTable> getPartnerCustomer() {
        return partnerCustomerRepository.findAll();
    }

    @PostMapping("/postpartnercustomer")
    public String postPartnerCustomer(@RequestBody PartnerCustomerNewTable partnerCustomerNewTable) {
        partnerCustomerRepository.save(partnerCustomerNewTable);
        return "Data Added Successfully";
    }

    @GetMapping("/getpaymentmode")
    public List<PaymentModeNewTable> getPaymentModeNewTable() {
        return paymentModeRepository.findAll();
    }

    @PostMapping("/postpaymentmode")
    public String postPaymentModeNewTable
            (@RequestBody PaymentModeNewTable paymentModeNewTable) {
        paymentModeRepository.save(paymentModeNewTable);
        return "Data Added Successfully";
    }

    @GetMapping("/getpenaltytype")
    public List<PenaltyTypeNewTable> getPenaltyTypeNewTable() {
        return penaltyTypeRepository.findAll();
    }

    @PostMapping("/postpenaltytype")
    public String postPenaltyTypeNewTable(@RequestBody PenaltyTypeNewTable penaltyTypeNewTable) {
        penaltyTypeRepository.save(penaltyTypeNewTable);
        return "Data Added Successfully";
    }

    @GetMapping("/getpenalty")
    public List<PenaltyNewTable> getPenaltyNewTable() {
        return penaltyRepository.findAll();
    }

    @PostMapping("/postpenalty/{emiId}/{penaltyTypeId}")
    public String postPenaltyNewTable
            (@PathVariable long emiId,
             @PathVariable long penaltyTypeId,
             @RequestBody PenaltyNewTable penaltyNewTable) {
        Optional<EMINewTable> emiNewTableOptional = emiRepository.findById(emiId);
        Optional<PenaltyTypeNewTable> penaltyTypeNewTableOptional = penaltyTypeRepository.findById(penaltyTypeId);

        penaltyNewTable.setEmiNewTable(emiNewTableOptional.get());
        penaltyNewTable.setPenaltyTypeNewTable(penaltyTypeNewTableOptional.get());

        penaltyRepository.save(penaltyNewTable);
        return "Data inserted Successfully!";
    }

}
