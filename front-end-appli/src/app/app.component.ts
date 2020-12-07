import { Component } from '@angular/core';
import { BugComponent } from './component/bug/bug.component';
import { DeveloppeurComponent } from './component/developpeur/developpeur.component';
import { HomeComponent } from './component/home/home.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front-end-appli';

  links = [ 
    {path:'home', component: HomeComponent, label:'Home'},
    {path:'devs', component: DeveloppeurComponent, label:'Developpeur'},
    {path:'bugs', component: BugComponent, label: 'Bugs'},
  ];
  activeLink = this.links[0];

  goToLink(url: string): void{
    window.open(url, '_blank');
}
}
