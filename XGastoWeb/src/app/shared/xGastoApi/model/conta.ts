/**
 * Swagger XGasto API
 * Documentação da API de acesso aos endpoints com Swagger
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { Audit } from './audit';


export interface Conta { 
    audit?: Audit;
    descricao?: string;
    id?: number;
    imgUrl?: string;
    saldo?: number;
}