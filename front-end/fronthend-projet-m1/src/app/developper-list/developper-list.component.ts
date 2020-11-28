import { DevelopperServiceService } from './../Services/developper-service.service';
import { Component, OnInit } from '@angular/core';
import { Developper } from '../Models/Developper';
import { delay } from 'rxjs/operators';


@Component({
  selector: 'app-developper-list',
  templateUrl: './developper-list.component.html',
  styleUrls: ['./developper-list.component.css']
})
export class DevelopperListComponent implements OnInit {

  public developper: Developper[];


  constructor(private developperService: DevelopperServiceService) { this.developper = [];}

  ngOnInit(): void {
    this.developperService.getDeveloppersList()
    .subscribe(((developperResponse: Developper[]) => {
      this.developper = developperResponse;
    }));
  }

  addDevelopper(newDevelopper: Developper): void {
    this.developper.push(newDevelopper);
  }

  deleteDevelopper(id: number): void {
    this.developperService.deleteDeveloppers(id).subscribe((deleteResponse) => {
      this.developper = this.developper.filter(d => d.id !== id);
    });
  }
}
