import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BugComponent } from './component/bug/bug.component';
import { DeveloppeurComponent } from './component/developpeur/developpeur.component';
import { HomeComponent } from './component/home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'devs', component: DeveloppeurComponent},
  {path: 'bugs', component: BugComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
