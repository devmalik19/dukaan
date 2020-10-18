package devmalik90.dukaan.service;

import devmalik90.dukaan.model.Address;
import devmalik90.dukaan.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService
{
    @Autowired
    private AddressRepository addressRepository;

    public Iterable<Address> getAll()
    {
        return addressRepository.findAll();
    }

    public Optional<Address> get(Integer id)
    {
        return addressRepository.findById(id);
    }

    public Optional<Address> create(Address address)
    {
        addressRepository.save(address);
        return addressRepository.findById(address.getId());
    }

    public Optional<Address> update(Address address)
    {
        addressRepository.save(address);
        return addressRepository.findById(address.getId());
    }

    public Optional<Address> delete(Address user)
    {
        addressRepository.delete(user);
        return addressRepository.findById(user.getId());
    }
}
