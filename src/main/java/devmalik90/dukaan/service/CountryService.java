package devmalik90.dukaan.service;

import devmalik90.dukaan.model.Address;
import devmalik90.dukaan.model.Country;
import devmalik90.dukaan.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService
{
    @Autowired
    private CountryRepository countryRepository;

    public Iterable<Country> getAll()
    {
        return countryRepository.findAll();
    }

    public Optional<Country> get(Integer id)
    {
        return countryRepository.findById(id);
    }

    public Optional<Country> create(Country country)
    {
        countryRepository.save(country);
        return countryRepository.findById(country.getId());
    }

    public Optional<Country> update(Country country)
    {
        countryRepository.save(country);
        return countryRepository.findById(country.getId());
    }

    public Optional<Country> delete(Country country)
    {
        countryRepository.delete(country);
        return countryRepository.findById(country.getId());
    }
}
