import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BugCreateComponent } from './component/bug-create/bug-create.component';
import { BugComponent } from './component/bug/bug.component';
import { DeveloppeurCreateComponent } from './component/developpeur-create/developpeur-create.component';
import { DeveloppeurComponent } from './component/developpeur/developpeur.component';
import { HomeComponent } from './component/home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'devs', component: DeveloppeurComponent},
  {path: 'devs/create', component: DeveloppeurCreateComponent},
  {path: 'bugs', component: BugComponent},
  {path: 'bugs/create', component: BugCreateComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
