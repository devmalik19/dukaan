package devmalik90.dukaan.service;

import devmalik90.dukaan.model.Address;
import devmalik90.dukaan.model.State;
import devmalik90.dukaan.repository.AddressRepository;
import devmalik90.dukaan.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService
{
    @Autowired
    private StateRepository stateRepository;

    public Iterable<State> getAll()
    {
        return stateRepository.findAll();
    }

    public Optional<State> get(Integer id)
    {
        return stateRepository.findById(id);
    }

    public Optional<State> create(State state)
    {
        stateRepository.save(state);
        return stateRepository.findById(state.getId());
    }

    public Optional<State> update(State state)
    {
        stateRepository.save(state);
        return stateRepository.findById(state.getId());
    }

    public Optional<State> delete(State state)
    {
        stateRepository.delete(state);
        return stateRepository.findById(state.getId());
    }
}
