package com.x.xgasto.service.impl;

import com.x.xgasto.domain.Banco;
import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.repository.BancoRepository;
import com.x.xgasto.repository.ContaRepository;
import com.x.xgasto.repository.UsuarioRepository;
import com.x.xgasto.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoServiceImpl implements BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Banco createOrUpdate(Banco banco) {

        this.bancoRepository.save(banco);

        //Usuario usuario = this.usuarioRepository.findById(idUsuario).orElse(null);

//        if (usuario != null && banco != null)
//        {
//            this.contaRepository.save(new Conta(usuario, banco));
//        }

        return banco;
    }

    @Override
    public Banco findById(Long idBanco) {
        return this.bancoRepository.findById(idBanco).orElse(null);
    }

    @Override
    public Boolean joinContaWithBanco(Banco banco, Usuario usuario) {
        return this.contaRepository.save(new Conta(usuario, banco)) == null;
    }

    @Override
    public void delete(Banco banco) {
        this.bancoRepository.delete(banco);
    }
}
