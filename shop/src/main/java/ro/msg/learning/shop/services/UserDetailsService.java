package ro.msg.learning.shop.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entities.Customer;
import ro.msg.learning.shop.repositories.CustomerRepository;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(username);
        if(customer!=null){
            return new User(customer.getUsername(), customer.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        }else throw new RuntimeException("Invalid user!");
    }
}
