package com.victor.HelpDesk;

import com.victor.HelpDesk.domain.Chamado;
import com.victor.HelpDesk.domain.Cliente;
import com.victor.HelpDesk.domain.Tecnico;
import com.victor.HelpDesk.domain.enums.Perfil;
import com.victor.HelpDesk.domain.enums.Prioridade;
import com.victor.HelpDesk.domain.enums.Status;
import com.victor.HelpDesk.domain.repository.ChamadoRepository;
import com.victor.HelpDesk.domain.repository.ClienteRepository;
import com.victor.HelpDesk.domain.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpDeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico tec1 = new Tecnico(null,"Valdir cezar", "123.456.789.00", "valdir@gmail.com", "123");
		tec1.addPerfil(Perfil.Admin);

		Cliente cli1 =new Cliente(null,"Linus Torvalds", "098.765.432.11","linus@gmail.com", "123");

		Chamado c1 =new Chamado(null, Prioridade.Media, Status.Andamento,"Chamado 1","primeiro chamdo", tec1,cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
