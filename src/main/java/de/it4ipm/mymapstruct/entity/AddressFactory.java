package de.it4ipm.mymapstruct.entity;

public class AddressFactory {

    public Address createAddress() {
        Address address = new Address();
        address.setStreet("Street");
        address.setCity("City");
        address.setZip("Zip");
        return address;
    }
}
