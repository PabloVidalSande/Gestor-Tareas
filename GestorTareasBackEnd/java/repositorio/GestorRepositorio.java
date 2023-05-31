package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.Tarea;

@Repository
public interface GestorRepositorio extends JpaRepository<Tarea, Long>{

}
