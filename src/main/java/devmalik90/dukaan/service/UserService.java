package devmalik90.dukaan.service;

import devmalik90.dukaan.model.User;
import devmalik90.dukaan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAll()
    {
        return userRepository.findAll();
    }

    public Optional<User> get(Integer id)
    {
        return userRepository.findById(id);
    }

    public void save(User user)
    {
        userRepository.save(user);
    }

    public void delete(User user)
    {
        userRepository.delete(user);
    }

}
