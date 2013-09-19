package br.com.twmtecnologia.entities.graph;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@NodeEntity
public class Country extends AbstractEntity{

	@Indexed(unique = true)
	String code;
	String name;

}
