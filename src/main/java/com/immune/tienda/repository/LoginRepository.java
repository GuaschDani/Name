package com.immune.tienda.repository;

import com.immune.tienda.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

    //Consulta que  devuelve la contraseña de un usuario dado su mail.
    @Query(value = "SELECT password FROM login WHERE mail = ?1", nativeQuery = true)
	public String getPassByMail(String mail);
    //Consulta que devuelve el rolID de un usuario dado su mail.
    @Query(value = "SELECT rolID FROM login WHERE mail = ?1", nativeQuery = true)
	public Integer getRolByMail(String mail);
}