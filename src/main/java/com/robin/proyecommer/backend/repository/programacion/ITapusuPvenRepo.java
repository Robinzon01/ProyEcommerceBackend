package com.robin.proyecommer.backend.repository.programacion;

import com.robin.proyecommer.backend.entity.TapusuPven;
import com.robin.proyecommer.backend.entity.TapusuPvenPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITapusuPvenRepo extends JpaRepository<TapusuPven, TapusuPvenPK> {
    @Query("SELECT a FROM TapusuPven a WHERE a.email = :email AND a.clave = :clave")
    Optional<TapusuPven> login(String email, String clave);
}
