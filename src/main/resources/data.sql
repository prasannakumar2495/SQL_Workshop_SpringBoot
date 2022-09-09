INSERT
INTO
  loans_new_table
  (loan_id, loanStatus, totalAmountPaid, totalLoanAmount, autoDebit, NOC, dateOfSanction, loanTypeNewTable_loan_type_id, customers_idcustomer, emiNewTableList_emi_id, bankDetailsNewTable_bank_account_number, loanOutlet_loan_outlet_id, partnerCustomerNewTable_partner_customer_id)
VALUES
  (/* put loan_id here */, '', 0, 0, 0, 0, '', NULL, NULL, NULL, NULL, NULL, NULL);

  INSERT
INTO
  penalty_new_table
  (penalty_id, penaltyType, penaltyAmount, emiNewTable_emi_id, penaltyTypeNewTable_penalty_type_id)
VALUES
  (/* put penalty_id here */, '', 0, NULL, NULL);