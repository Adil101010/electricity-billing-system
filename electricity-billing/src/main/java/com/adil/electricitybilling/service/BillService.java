package com.adil.electricitybilling.service;

import com.adil.electricitybilling.model.Bill;
import com.adil.electricitybilling.model.Consumer;
import com.adil.electricitybilling.repository.BillRepository;
import com.adil.electricitybilling.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ConsumerRepository consumerRepository;

    public Bill createBill(Bill bill) {
        if (bill.getConsumer() != null && bill.getConsumer().getId() != null) {
            Consumer consumer = consumerRepository.findById(bill.getConsumer().getId())
                    .orElseThrow(() -> new RuntimeException("Consumer not found"));
            bill.setConsumer(consumer);
        }
        return billRepository.save(bill);
    }
    public Bill updateBill(Long id, Bill updatedBill) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));

        bill.setAmount(updatedBill.getAmount());
        bill.setDueDate(updatedBill.getDueDate());
        // Optionally update other fields if needed
        return billRepository.save(bill);
    }

    public void deleteBill(Long id) {
        if (!billRepository.existsById(id)) {
            throw new RuntimeException("Bill not found with id: " + id);
        }
        billRepository.deleteById(id);
    }

    public String markBillAsPaid(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));
        bill.setPaid(true);
        billRepository.save(bill);
        return "Bill marked as paid successfully.";
    }

    public List<Bill> getBillsByConsumer(Long consumerId) {
        return billRepository.findByConsumerId(consumerId); // You must have this method in repository
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public List<Bill> getPaidBills() {
        return billRepository.findByPaidTrue();
    }

    public List<Bill> getUnpaidBills() {
        return billRepository.findByPaidFalse();
    }

    public Double getTotalDueAmount(Long consumerId) {
        return billRepository.getTotalDueAmountByConsumerId(consumerId);
    }

    public Double getTotalDueAmountByConsumerId(Long consumerId) {
        return billRepository.getTotalDueAmountByConsumerId(consumerId);
    }

    // ✅ Added method to support controller's getBillById
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElse(null);
    }
}
