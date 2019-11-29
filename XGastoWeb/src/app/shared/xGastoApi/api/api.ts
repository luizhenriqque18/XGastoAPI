export * from './contaController.service';
import { ContaControllerService } from './contaController.service';
export * from './gastoController.service';
import { GastoControllerService } from './gastoController.service';
export * from './pessoaController.service';
import { PessoaControllerService } from './pessoaController.service';
export * from './usuarioController.service';
import { UsuarioControllerService } from './usuarioController.service';
export const APIS = [ContaControllerService, GastoControllerService, PessoaControllerService, UsuarioControllerService];
