package com.vnxt.service;

import com.vnxt.model.Address;
import com.vnxt.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements CrudService<Address> {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public Address create(Address address) {
        sendMessage(address);
        return addressRepository.save(address);

    }

    @Override
    public Address retrieve(int id) {
        return null;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Address> retrieveAll() {
        return null;
    }



    private void sendMessage(Address address) {
        kafkaTemplate.send("ADDRESS_TOPIC", address.getAddressLine1());
    }
}
