import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Developpeur } from 'src/app/models/Developpeur';
import { DeveloppeurService } from 'src/app/services/developpeur.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatButtonModule } from '@angular/material/button';


@Component({
  selector: 'app-developpeur',
  templateUrl: './developpeur.component.html',
  styleUrls: ['./developpeur.component.css']
})
export class DeveloppeurComponent implements  AfterViewInit {

  public developpeurs: Developpeur[] = [];
  displayedColumns: string[] = ['ID', 'name', 'firstname', 'details'];
  dataSource!: MatTableDataSource<Developpeur>;
  
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  @ViewChild(MatSort) 
  sort!: MatSort;

  constructor(private devsServices: DeveloppeurService) { 
    this.devsServices.getDeveloppeursList().subscribe((devsReponse => {
      this.dataSource = new MatTableDataSource(devsReponse);
      setTimeout(() => this.dataSource.paginator = this.paginator);
    }));
  }


  deleteDeveloppeur(id: number): void{
    this.devsServices.deleteDeveloppeur(id).subscribe((deleteResponse) =>{
      this.developpeurs = this.developpeurs.filter(devs => devs.id !== id);
    }, (error) => {
      //TODO
    })
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

}
