package br.com.twmtecnologia.entities.graph;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;


import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@NodeEntity
public class Customer extends AbstractEntity{
	
	public Customer(){
		
	}
public Customer(String firstName){
		this.firstName = firstName;
	}
	
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	private String emailAddress;
	@RelatedTo(type="ADDRESS")
	private Set<Address> addresses = new HashSet<Address>();
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}
