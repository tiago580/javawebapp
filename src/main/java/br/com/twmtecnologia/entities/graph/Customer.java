package br.com.twmtecnologia.entities.graph;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;


import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@NodeEntity
public class Customer extends AbstractEntity{
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	private String emailAddress;
	@RelatedTo(type="ADDRESS")
	private Set<Address> addresses = new HashSet<Address>();
}
