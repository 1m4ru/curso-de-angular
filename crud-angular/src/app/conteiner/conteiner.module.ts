import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ConteinerRoutingModule } from './conteiner-routing.module';
import { ConteinerComponent } from './conteiner/conteiner.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    ConteinerComponent
  ],
  imports: [
    CommonModule,
    ConteinerRoutingModule,
    AppMaterialModule,
    SharedModule

  ]
})
export class ConteinerModule { }
