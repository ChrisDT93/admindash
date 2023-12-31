package com.admindash.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class CustomerJPADataAccessService implements CustomerDAO {

    private final CustomerRespository customerRespository;

    public CustomerJPADataAccessService(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRespository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRespository.findById(id);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRespository.save(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customerRespository.existsCustomerByEmail(email);
    }

    @Override
    public boolean existsPersonWithId(Integer customerId) {
        return customerRespository.existsCustomerById(customerId);
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        customerRespository.deleteById(customerId);
    }

    @Override
    public void updateCustomer(Customer update) {
        customerRespository.save(update);
    }
}
