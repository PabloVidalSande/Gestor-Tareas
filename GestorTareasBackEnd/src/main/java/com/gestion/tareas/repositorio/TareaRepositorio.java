package com.gestion.tareas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.tareas.modelo.Tarea;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Long>{

}
