import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Developpeur } from 'src/app/models/Developpeur';
import { DeveloppeurService } from 'src/app/services/developpeur.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatDialog, } from '@angular/material/dialog';
import { DeveloppeurDetailComponent } from '../developpeur-detail/developpeur-detail.component';


@Component({
  selector: 'app-developpeur',
  templateUrl: './developpeur.component.html',
  styleUrls: ['./developpeur.component.css']
})
export class DeveloppeurComponent implements  AfterViewInit {

  public developpeurs!: Developpeur[];
  public devsUnit!: Developpeur;
  displayedColumns: string[] = ['ID', 'name', 'firstname', 'details'];

  dataSource!: MatTableDataSource<Developpeur>;
  
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  @ViewChild(MatSort) 
  sort!: MatSort;

  constructor(private devsServices: DeveloppeurService, public dialog: MatDialog) { 
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

  openDialog(developper:any): void {
    const dialogRef = this.dialog.open(DeveloppeurDetailComponent, {
      width: '330px',
      height: '400px',
      data: {
        name: developper.name,
        firstname: developper.firstname,
        function: developper.function
      }
    });
  }
}
