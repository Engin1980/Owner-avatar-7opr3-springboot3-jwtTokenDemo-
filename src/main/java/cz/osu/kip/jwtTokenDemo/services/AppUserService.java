package cz.osu.kip.jwtTokenDemo.services;

import cz.osu.kip.jwtTokenDemo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser appUser = getAppUserByUsername(username);
    UserDetails ret = appUser;
    return ret;
  }

  private AppUser getAppUserByUsername(String username) throws UsernameNotFoundException {
    if (!username.contains("@"))
      throw new UsernameNotFoundException(String.format("User %s not found.", username));
    String password = username.split("@")[0];
    String hash = passwordEncoder.encode(password);
    AppUser ret = new AppUser(username, hash);
    return ret;
  }
}
