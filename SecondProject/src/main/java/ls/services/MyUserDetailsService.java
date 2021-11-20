//package ls.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import ls.models.User;
//import ls.models.UserPrincipal;
//import ls.repositories.UserRepository;
//
//public class MyUserDetailsService implements UserDetailsService {
//	@Autowired UserRepository  userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//			User user=userRepository.findByUsername(username);
//			if(user == null) {
//				throw new UsernameNotFoundException("user not found");
//			}
//			return new UserPrincipal(user);
//	}
//
//}
