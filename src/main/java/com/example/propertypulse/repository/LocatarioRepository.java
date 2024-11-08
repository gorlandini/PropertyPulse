package com.example.propertypulse.repository;



import com.example.propertypulse.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
}
