package com.x.xgasto.service.impl;

import com.x.xgasto.domain.Gasto;
import com.x.xgasto.repository.GastoRepository;
import com.x.xgasto.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public Gasto create(Gasto gasto) {
        return this.gastoRepository.save(gasto);
    }

    @Override
    public Gasto findById(Long idGasto) {
        return this.gastoRepository.findById(idGasto).orElse(null);
    }

    @Override
    public void delete(Gasto gasto) {
        this.gastoRepository.delete(gasto);
    }
}
