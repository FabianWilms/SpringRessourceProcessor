package de.wilms.springtest.repositories;

import de.wilms.springtest.entities.Citizen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(exported = true, path="citizens", collectionResourceRel="citizens")
public interface CitizenRepository extends CrudRepository<Citizen, UUID>{}
