package quizzbaseOneToMany.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import quizzbaseOneToMany.dao.UsuarioDao;
import quizzbaseOneToMany.model.Clasificacion;
import quizzbaseOneToMany.model.Usuario;
import quizzbaseOneToMany.service.ClasificacionService;
import quizzbaseOneToMany.service.UsuarioService;

@Controller
public class Controlador implements ErrorController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ClasificacionService clasificacionService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	
	@PostMapping("/pregunta1")
	public String pregunta1(@RequestParam("msg") String msg, HttpServletRequest request) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES"); //Intentamos recuperar la lista mensajes como variable de sesion(con el get).Sin embargo al ser el primer quizz esta lista no está creada con anterioridad
		if (messages == null) { //Asi que como la lista no esta creada entra en el if
			messages = new ArrayList<>(); //Ne creo la lista 
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages); //Guardo la lista como variable de sesion con el set poniendole como nombre("My Session Messages").Este será el nombre que tendre que utilizar en el get para recuperar la lista en futuras ocasiones
		}
        //Añado la respuesta a la lista 
		messages.add(msg);

		// System.out.println(msg); // imprime brasil
        //Vuelvo a guardar la lista actualiza como variable de sesion con el get
		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "pregunta1";
	}

	@PostMapping("/pregunta2")
	public String p2(@RequestParam("msg") String msg, HttpServletRequest request) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);

		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "pregunta2";
	}

	@PostMapping("/pregunta3")
	public String p3(@RequestParam("msg") String msg, HttpServletRequest request) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);

		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "pregunta3";
	}

	@PostMapping("/pregunta4")
	public String p4(@RequestParam("msg") String msg, HttpServletRequest request) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);

		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "pregunta4";
	}

	@PostMapping("/pregunta5")
	public String p5(@RequestParam("msg") String msg, HttpServletRequest request) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);

		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "pregunta5";
	}

	@PostMapping("pregunta6")
	public String p6(@RequestParam("msg") String msg, HttpServletRequest request) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);

		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "pregunta6";
	}

	@PostMapping("/pregunta7")
	public String p7(@RequestParam("msg") String msg, HttpServletRequest request) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);

		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "pregunta7";
	}

	// *********************************************************************
	@PostMapping("/session")
	public String p7(@RequestParam("msg") String msg, HttpServletRequest request, Model model) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);

		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);

		model.addAttribute("sessionMessages", messages);

	

		int puntuacion = 0;

		String respuestas[] = { "nombreusuario", "33", "Alonso", "RedBullRing", "97", "Hungria", "2005", "Button" };

		System.out.println("tamanio " + messages.size());

		for (int i = 0; i < messages.size(); i++) {

			if (messages.contains(respuestas[i])) {

				puntuacion++;

			}

		}
		// System.out.println("Puntuacion: " + puntuacion);

		String clasificacionjugador = "";
		if (puntuacion < 2) {
			clasificacionjugador = "Novato";
		} else if (puntuacion < 4) {
			clasificacionjugador = "Decente";
		} else if (puntuacion < 6) {
			clasificacionjugador = "Experto";
		} else {
			clasificacionjugador = "Genio";
		}

		Usuario usuario = null;
		Usuario usuarioGuardar = new Usuario();
		Clasificacion clasificacionUsuario = new Clasificacion();

		try {
			usuario = usuarioService.getUsuarioById(messages.get(0));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			usuario = null;
			System.out.println(usuario);
		}

		if (usuario != null) {
			usuarioGuardar = usuario.asignar(usuario, messages);

			System.out.println(usuario);
			usuarioService.updateUsuario(usuarioGuardar);
		} else {
			usuario = new Usuario();
			usuarioGuardar = usuario.asignar(usuario, messages);
			usuarioService.saveUsuario(usuarioGuardar);
		}
		Calendar calendar = Calendar.getInstance();
		String dia = Integer.toString(calendar.get(Calendar.DATE));
		String mes = Integer.toString(calendar.get(Calendar.MONTH));
		String annio = Integer.toString(calendar.get(Calendar.YEAR));
		String hora = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
		String minutos = Integer.toString(calendar.get(Calendar.MINUTE));
		String segundos = Integer.toString(calendar.get(Calendar.SECOND));
		String fecha = dia + "-" + mes + "-" + annio + " " + hora + ":" + minutos + ":" + segundos;

		clasificacionUsuario.setClasificacion(clasificacionjugador);		
		clasificacionUsuario.setUsuario(usuarioGuardar);
		clasificacionUsuario.setFecha(fecha);
		clasificacionUsuario.setPuntuacion(puntuacion);

		clasificacionService.saveClasificacion(clasificacionUsuario);

		System.out.println("Clasificacion 1: " + clasificacionjugador);

		model.addAttribute("clasificacionjugador",clasificacionjugador);
		model.addAttribute("puntuacion",puntuacion);

		return "mostrar";
	}
	@GetMapping("/sesionDestruida")
	public String sesionDestruida() {
		return "sesionDestruida";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/otros")
	public String otrosUsuarios(Model model,HttpServletRequest request) {
	model.addAttribute("Usuarios",usuarioService.getAllUsuarios());
	model.addAttribute("Clasificaciones",clasificacionService.getAllClasificaciones());
	return "resultadosUsuarios";
	}
	
	
	@GetMapping ("/borrarusuario/{nombre}")
	public String borrarlibro(@PathVariable("nombre") String nombre) {
		usuarioService.deleteUsuarioById(nombre);
		return "redirect:/otros";
	}
	

	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/sesionDestruida";
	}

	// *********************************************************************

	
}