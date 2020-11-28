import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DevelopperListComponent } from './developper-list/developper-list.component';

const routes: Routes = [
  {path: 'devs', component:DevelopperListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
