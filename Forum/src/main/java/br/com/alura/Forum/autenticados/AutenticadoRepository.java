package br.com.alura.Forum.autenticados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AutenticadoRepository extends JpaRepository<Autenticado, Long> {
    UserDetails findByLogin(String login);
}
