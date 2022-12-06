import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { ConteinerService } from './../services/conteiner.service';
import { Conteiner } from '../model/conteiner';


import { Component, OnInit } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-conteiner',
  templateUrl: './conteiner.component.html',
  styleUrls: ['./conteiner.component.scss']
})
export class ConteinerComponent implements OnInit {

  conteiner$: Observable<Conteiner[]>;
  displayedColumns = ['client', 'type', 'numberOfConteiner', 'status', 'category', 'name']


  constructor(
    private conteinerService: ConteinerService,
    public dialog: MatDialog
    ) {

    this.conteiner$ = this.conteinerService.list()
    .pipe(
      catchError(error => {
       this.onError('Erro ao pesquisar os Contêiners');
        return of([])
      })
    );
   }
   onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void {
  }

}
