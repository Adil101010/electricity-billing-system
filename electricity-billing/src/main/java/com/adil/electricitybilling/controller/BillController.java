package com.adil.electricitybilling.controller;

import com.adil.electricitybilling.model.Bill;
import com.adil.electricitybilling.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @GetMapping("/paid")
    public List<Bill> getPaidBills() {
        return billService.getPaidBills();
    }

    @GetMapping("/unpaid")
    public List<Bill> getUnpaidBills() {
        return billService.getUnpaidBills();
    }

    @Autowired
    private BillService billService;

    @GetMapping("/total-due/{consumerId}")
    public Double getTotalDueAmount(@PathVariable Long consumerId) {
        return billService.getTotalDueAmountByConsumerId(consumerId);
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        Bill bill = billService.getBillById(id);
        if (bill == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bill);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill updatedBill) {
        Bill bill = billService.updateBill(id, updatedBill);
        return ResponseEntity.ok(bill);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted successfully");
    }

    @PutMapping("/{id}/pay")
    public String markBillAsPaid(@PathVariable Long id) {
        return billService.markBillAsPaid(id);
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/consumer/{consumerId}")
    public List<Bill> getBillsByConsumer(@PathVariable Long consumerId) {
        return billService.getBillsByConsumer(consumerId);
    }

}
