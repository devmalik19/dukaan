package devmalik90.dukaan.controller;

import devmalik90.dukaan.exception.ResourceNotFoundException;
import devmalik90.dukaan.helper.RestControllerResponse;
import devmalik90.dukaan.model.User;
import devmalik90.dukaan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    private RestControllerResponse restControllerResponse;

    @GetMapping("/all")
    public Iterable<User> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public RestControllerResponse get(@PathVariable("id") Integer id) throws ResourceNotFoundException
    {
        Optional<User> optional = userService.get(id);
        return prepareResponse(optional,"Success","User not found");
    }

    @PutMapping
    public RestControllerResponse create(@Valid @RequestBody User user) throws ResourceNotFoundException
    {
        Optional<User> optional = userService.get(user.getId());
        optional.ifPresent(u->userService.save(u));
        return prepareResponse(optional,"Success","User not found");
    }

    @PostMapping()
    public RestControllerResponse update(@Valid @RequestBody User user) throws ResourceNotFoundException
    {
        Optional<User> optional = userService.get(user.getId());
        optional.ifPresent(u->userService.save(u));
        return prepareResponse(optional,"Updated","User not found");
    }

    @DeleteMapping("/{id}")
    public RestControllerResponse delete(@PathVariable("id") Integer id) throws ResourceNotFoundException
    {
        Optional<User> optional = userService.get(id);
        optional.ifPresent(u->userService.delete(u));
        return prepareResponse(optional,"Deleted","User not found");
    }

    private RestControllerResponse prepareResponse(Optional optional,String successMessage, String errorMessage)
    {
        if (optional.isPresent())
            restControllerResponse.setMessage(successMessage);
        else
            new ResourceNotFoundException(errorMessage);
        restControllerResponse.setResponseObject(optional);
        return restControllerResponse;
    }
}
