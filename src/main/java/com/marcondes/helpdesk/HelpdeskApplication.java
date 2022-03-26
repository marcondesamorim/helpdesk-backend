package com.marcondes.helpdesk;

import java.util.Arrays;

import com.marcondes.helpdesk.domain.Chamado;
import com.marcondes.helpdesk.domain.Cliente;
import com.marcondes.helpdesk.domain.Tecnico;
import com.marcondes.helpdesk.domain.enums.Perfil;
import com.marcondes.helpdesk.domain.enums.Prioridade;
import com.marcondes.helpdesk.domain.enums.Status;
import com.marcondes.helpdesk.repository.ChamadoRepository;
import com.marcondes.helpdesk.repository.ClienteRepository;
import com.marcondes.helpdesk.repository.TecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Marcondes", "57956439043", "marcondes@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linus Tovalds", "70511744013", "tovalds@mail.com", "123");
		cli1.addPerfil(Perfil.CLIENTE);

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));

		clienteRepository.saveAll(Arrays.asList(cli1));

		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
