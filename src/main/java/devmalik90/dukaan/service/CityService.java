package devmalik90.dukaan.service;

import devmalik90.dukaan.model.City;
import devmalik90.dukaan.model.State;
import devmalik90.dukaan.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService
{
    @Autowired
    private CityRepository cityRepository;

    public Iterable<City> getAll()
    {
        return cityRepository.findAll();
    }

    public Optional<City> get(Integer id)
    {
        return cityRepository.findById(id);
    }

    public Optional<City> create(City city)
    {
        cityRepository.save(city);
        return cityRepository.findById(city.getId());
    }

    public Optional<City> update(City city)
    {
        cityRepository.save(city);
        return cityRepository.findById(city.getId());
    }

    public Optional<City> delete(City city)
    {
        cityRepository.delete(city);
        return cityRepository.findById(city.getId());
    }
}
