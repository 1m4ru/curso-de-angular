import { Conteiner } from './../../conteiners/conteiners.module';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { delay, first, tap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ConteinerService {

  private readonly API = '/api/conteiner';

  constructor(private HttpClient: HttpClient) { }

  list(){
    return this.HttpClient.get<Conteiner[]>(this.API)
    .pipe(
      first(),
      delay(5000),
      tap(conteiners => console.log(conteiners))
    );
  }
}
