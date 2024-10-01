package com.si.apirest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.si.apirest.entity.PermissionEntity;
import com.si.apirest.entity.Person;
import com.si.apirest.entity.RoleEntity;
import com.si.apirest.enums.Permission;
import com.si.apirest.enums.Role;
import com.si.apirest.repository.PermissionRepository;
import com.si.apirest.repository.PersonRepository;
import com.si.apirest.repository.RolRepository;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ApirestApplication.class, args);

		//Tomar todos los beans del contexto de spring
		PermissionRepository permissionRepository = context.getBean(PermissionRepository.class);
		RolRepository rolRepository = context.getBean(RolRepository.class); 
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
		ModelMapper modelMapper = context.getBean(ModelMapper.class);

		//si no existen permisos y roles los crea
		if (permissionRepository.count()==0 && rolRepository.count() == 0){
			Set<PermissionEntity> permissionEntities = new HashSet<PermissionEntity>();
			List<PermissionEntity> permissionEntitiesSaved = new ArrayList<PermissionEntity>();
			//Guarda todos los permisos del enum Permission
			for (String nombre : Permission.getAllPermissionNames()) {
				permissionEntities.add(PermissionEntity.builder().nombre(nombre).build());
			}
			permissionEntitiesSaved = permissionRepository.saveAllAndFlush(permissionEntities);

			//Se guarda el Rol ADMIN
			RoleEntity rolSaved = rolRepository.save(RoleEntity.builder()
															.name(Role.ADMINISTRADOR.toString())
															.permissions(permissionEntitiesSaved)
															.build());
			//Se guarda el Rol USER
			List<PermissionEntity> permissionUser = new ArrayList<PermissionEntity>();
			for (PermissionEntity permission : permissionEntitiesSaved){
				if(permission.getNombre().equals(Permission.VER_HOME.toString()))
					permissionUser.add(permission);
			}
			System.out.println("Llegó aquí 1");
			rolRepository.save(RoleEntity.builder()
										.name(Role.USUARIO.toString())
										.permissions(permissionUser)
										.build());
			System.out.println("Llegó aquí 2");
			
			
			//Crea el usuario Admin
			createUserAdmin(personRepository, rolSaved,passwordEncoder, modelMapper);
		}

	}

	private static void createUserAdmin(PersonRepository personRepository,RoleEntity rol, PasswordEncoder passwordEncoder,
	ModelMapper modelMapper
	) {
		Optional<Person> optionalUser = personRepository.findByUsuario(Role.ADMINISTRADOR.toString());
        Person user= Person.builder()
		.usuario(Role.ADMINISTRADOR.toString())
		.contraseña(passwordEncoder.encode("78023575"))
		.nombre("ADMINISTRADOR")
		.email("groverchoquevillca80@gmail.com")
		.role(rol)
		.enabled(true)
		.build();

		optionalUser.ifPresent(userAdmin-> {
			modelMapper.map(userAdmin, user);
		});
		
		personRepository.save(user);
	}

}
