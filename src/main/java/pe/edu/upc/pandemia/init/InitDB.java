package pe.edu.upc.pandemia.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.User;
import pe.edu.upc.pandemia.model.repository.EmployeeRepository;
import pe.edu.upc.pandemia.model.repository.UserRepository;

@Service
public class InitDB implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;	
	
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
	// SOLO DESBLOQUEAR CUANDO SE CREEN LOS USUARIOS DE FORMA MANUAL	
	/*		
		Employee employeeErrazuriz = null;
		Employee employeeBanda = null;

		employeeErrazuriz = employeeRepository.findById(147).get();
		employeeBanda = employeeRepository.findById(167).get();
	
		User errazuriz = new User();
		
		errazuriz.setEmployee(employeeErrazuriz);
		employeeErrazuriz.setUser(errazuriz);
		
		errazuriz.setId(147);
		errazuriz.setUsername("aerrazuriz");
		errazuriz.setPassword(bcpe.encode("errazuriz"));
		errazuriz.setEnable(true);
		
		User banda = new User();
		
		banda.setEmployee(employeeBanda);
		employeeBanda.setUser(banda);
		
		banda.setId(167);
		banda.setUsername("abanda");
		banda.setPassword(bcpe.encode("banda"));
		banda.setEnable(true);
	
		// ROLE -> Segmento objetivo
		errazuriz.addAuthority("ROLE_MANAGER");
		banda.addAuthority("ROLE_EMPLOYEE");
		
		// ACCESS
		errazuriz.addAuthority("ACCESS_VIP");
		errazuriz.addAuthority("ACCESS_VIEW_EMPLOYEE");
		errazuriz.addAuthority("ACCESS_MODIFY_EMPLOYEE");
		banda.addAuthority("ACCESS_VIEW_EMPLOYEE");

		userRepository.save(errazuriz);
		userRepository.save(banda);*/
	}
}
