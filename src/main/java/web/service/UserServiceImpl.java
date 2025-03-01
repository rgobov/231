package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repositories.PeopleRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService  {

    private final PeopleRepo peopleRepo;

    @Autowired
    public UserServiceImpl(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public List<User> findAll() {
        return peopleRepo.findAll();
    }
    public User findById(int id) {
        Optional<User> user = peopleRepo.findById(id);
        return user.orElse(null);
    }
    @Transactional
    public void save(User user) {
        peopleRepo.save(user);
    }
    @Transactional
    public void update( int id, User updateuser) {
        updateuser.setId(id);
        peopleRepo.save(updateuser);
    }
    @Transactional
    public void delete(int id) {
        peopleRepo.deleteById(id);
    }
}
