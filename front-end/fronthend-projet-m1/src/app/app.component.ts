import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'fronthend-projet-m1';
  goToLink(url: string): void{
      window.open(url, '_blank');
  }
}
