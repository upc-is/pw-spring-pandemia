package pe.edu.upc.pandemia.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	// EmbeddedId primary key
	@Id
	private Integer id;
	
	@Column(name = "username", length = 30, nullable = false)
	private String username;
	
	@Column(name = "password", length = 60, nullable = false)
	private String password;
	
	@Column(name = "enable")
	private boolean enable;
	
	// cascade = CascadeType.ALL, para que se actualice tambien el employee
	// Corrección para que funcione el grabado de los usuarios
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "id")
	private Employee employee;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Authority> authorities;
	
	public User() {
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	public User( String username, String password ) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	
	// Agregar el ROLE o ACCESS al usuario
	public void addAuthority( String auth ) {
		Authority authority = new Authority();
		authority.setAuthority( auth ) ;
		authority.setUser( this );
		
		this.authorities.add( authority );
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
}
