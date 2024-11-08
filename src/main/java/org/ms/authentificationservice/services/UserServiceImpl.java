package org.ms.authentificationservice.services;
import org.ms.authentificationservice.entities.AppRole;
import org.ms.authentificationservice.entities.AppUser;
import org.ms.authentificationservice.repositories.AppRoleRepository;
import org.ms.authentificationservice.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	//déclaration d’un attribut
	private PasswordEncoder passwordEncoder=null;
 private final AppUserRepository appUserRepository;
 private final AppRoleRepository appRoleRepository;

 public UserServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository,PasswordEncoder passwordEncoder) {
     this.appUserRepository = appUserRepository;
     this.appRoleRepository = appRoleRepository;
     this.passwordEncoder=passwordEncoder;
 }
 



@Override
public AppUser addUser(AppUser appUser) {
 appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
 return appUserRepository.save(appUser);
}
 @Override
 public AppRole addRole(AppRole appRole) {
     return appRoleRepository.save(appRole);
 }

 @Override
 public void addRoleToUser(String username, String roleName) {
     AppUser user = appUserRepository.findByUsername(username);
     AppRole role = appRoleRepository.findByRoleName(roleName);
     user.getRoles().add(role);
     appUserRepository.save(user);
 }

 @Override
 public AppUser getUserByName(String username) {
     return appUserRepository.findByUsername(username);
 }

 @Override
 public List<AppUser> getAllUsers() {
     return appUserRepository.findAll();
 }
}
