package com.admindash.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
){

}
