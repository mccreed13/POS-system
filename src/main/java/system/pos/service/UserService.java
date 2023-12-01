package system.pos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.pos.entity.User;
import system.pos.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public void createWaiter(User user){
        userRepository.save(user);
    }

    public void updateWaiter(User user){
        userRepository.save(user);
    }

    public void deleteWaiterById(Long id){
        userRepository.deleteById(id);
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }
}
