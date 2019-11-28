package com.x.xgasto.service.impl;

import com.x.xgasto.domain.CategoriaGasto;
import com.x.xgasto.repository.CategoriaGastoRepository;
import com.x.xgasto.service.CategoriaGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaGastoServiceImpl implements CategoriaGastoService {

    @Autowired
    private CategoriaGastoRepository categoriaGastoRepository;

    @Override
    public CategoriaGasto findById(Long idCategoriaGasto) {
        return this.categoriaGastoRepository.findById(idCategoriaGasto).orElse(null);
    }
}
