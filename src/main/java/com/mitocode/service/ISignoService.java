package com.mitocode.service;

import com.mitocode.model.Signo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISignoService extends ICRUD<Signo, Integer>{

    Page<Signo> listarPageable(Pageable pageable);



}
