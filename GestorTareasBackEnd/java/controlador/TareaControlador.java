package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import modelo.Tarea;
import repositorio.GestorRepositorio;

@RestController
@RequestMapping("/api/v1/")
public class TareaControlador {
	@Autowired
	private GestorRepositorio repositorio;

	@GetMapping("/tareas")
	public List<Tarea> listarTodasLasTareas() {
		return repositorio.findAll();
	}
}
