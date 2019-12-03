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
/* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent }                           from '@angular/common/http';
import { CustomHttpUrlEncodingCodec }                        from '../encoder';

import { Observable }                                        from 'rxjs/Observable';

import { ContaDto } from '../model/contaDto';
import { ResponseContaDto } from '../model/responseContaDto';
import { Responsestring } from '../model/responsestring';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class ContaControllerService {

    protected basePath = 'http://localhost:8080';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
            this.basePath = basePath || configuration.basePath || this.basePath;
        }
    }

    /**
     * @param consumes string[] mime-types
     * @return true: consumes contains 'multipart/form-data', false: otherwise
     */
    private canConsumeForm(consumes: string[]): boolean {
        const form = 'multipart/form-data';
        for (const consume of consumes) {
            if (form === consume) {
                return true;
            }
        }
        return false;
    }


    /**
     * create
     * 
     * @param idUsuario idUsuario
     * @param contaDto contaDto
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public createUsingPOST(idUsuario: number, contaDto: ContaDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseContaDto>;
    public createUsingPOST(idUsuario: number, contaDto: ContaDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseContaDto>>;
    public createUsingPOST(idUsuario: number, contaDto: ContaDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseContaDto>>;
    public createUsingPOST(idUsuario: number, contaDto: ContaDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (idUsuario === null || idUsuario === undefined) {
            throw new Error('Required parameter idUsuario was null or undefined when calling createUsingPOST.');
        }

        if (contaDto === null || contaDto === undefined) {
            throw new Error('Required parameter contaDto was null or undefined when calling createUsingPOST.');
        }

        let queryParameters = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
        if (idUsuario !== undefined && idUsuario !== null) {
            queryParameters = queryParameters.set('idUsuario', <any>idUsuario);
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.post<ResponseContaDto>(`${this.basePath}/api/conta/create`,
            contaDto,
            {
                params: queryParameters,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * delete
     * 
     * @param idConta idConta
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public deleteUsingDELETE(idConta: number, observe?: 'body', reportProgress?: boolean): Observable<Responsestring>;
    public deleteUsingDELETE(idConta: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<Responsestring>>;
    public deleteUsingDELETE(idConta: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<Responsestring>>;
    public deleteUsingDELETE(idConta: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (idConta === null || idConta === undefined) {
            throw new Error('Required parameter idConta was null or undefined when calling deleteUsingDELETE.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];

        return this.httpClient.delete<Responsestring>(`${this.basePath}/api/conta/delete/${encodeURIComponent(String(idConta))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * findByIdConta
     * 
     * @param idConta idConta
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public findByIdContaUsingGET(idConta: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseContaDto>;
    public findByIdContaUsingGET(idConta: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseContaDto>>;
    public findByIdContaUsingGET(idConta: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseContaDto>>;
    public findByIdContaUsingGET(idConta: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (idConta === null || idConta === undefined) {
            throw new Error('Required parameter idConta was null or undefined when calling findByIdContaUsingGET.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];

        return this.httpClient.get<ResponseContaDto>(`${this.basePath}/api/conta/findConta/${encodeURIComponent(String(idConta))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * update
     * 
     * @param idConta idConta
     * @param contaDto contaDto
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public updateUsingPUT(idConta: number, contaDto: ContaDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseContaDto>;
    public updateUsingPUT(idConta: number, contaDto: ContaDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseContaDto>>;
    public updateUsingPUT(idConta: number, contaDto: ContaDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseContaDto>>;
    public updateUsingPUT(idConta: number, contaDto: ContaDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (idConta === null || idConta === undefined) {
            throw new Error('Required parameter idConta was null or undefined when calling updateUsingPUT.');
        }

        if (contaDto === null || contaDto === undefined) {
            throw new Error('Required parameter contaDto was null or undefined when calling updateUsingPUT.');
        }

        let queryParameters = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
        if (idConta !== undefined && idConta !== null) {
            queryParameters = queryParameters.set('idConta', <any>idConta);
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.put<ResponseContaDto>(`${this.basePath}/api/conta/update`,
            contaDto,
            {
                params: queryParameters,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}