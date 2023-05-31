package com.gestion.tareas.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.tareas.excepciones.ResourceNotFoundException;
import com.gestion.tareas.modelo.Tarea;
import com.gestion.tareas.repositorio.TareaRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class TareaControlador {

	@Autowired
	private TareaRepositorio repositorio;

	//este metodo sirve para listar todos las tareas
	@GetMapping("/tareas")
	public List<Tarea> listarTodasLasTareas() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar la tarea
	@PostMapping("/tareas")
	public Tarea guardarTarea(@RequestBody Tarea tarea) {
		tarea.setRealizada(false);
		return repositorio.save(tarea);
	}
    
	//este metodo sirve para buscar una tarea
	@GetMapping("/tareas/{id}")
	public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id){
			Tarea tarea = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe la tarea con el ID : " + id));
			return ResponseEntity.ok(tarea);
	}
	
	//este metodo sirve para actualizar tarea
	@PutMapping("/tareas/{id}")
	public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id,@RequestBody Tarea detallesTarea){
		Tarea tarea = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la tarea con el ID : " + id));
		
		tarea.setNombre(detallesTarea.getNombre());
		tarea.setAsignado(detallesTarea.getAsignado());
		tarea.setDescripcion(detallesTarea.getDescripcion());
		tarea.setRealizada(detallesTarea.getRealizada());
		
		Tarea tareaActualizada = repositorio.save(tarea);
		return ResponseEntity.ok(tareaActualizada);
    }
	
	//este metodo sirve para eliminar una tarea
	@DeleteMapping("/tareas/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarTarea(@PathVariable Long id){
		Tarea tarea = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la tarea con el ID : " + id));
		
		repositorio.delete(tarea);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














