package com.marcondes.helpdesk.repositories;

import com.marcondes.helpdesk.domain.Chamado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
