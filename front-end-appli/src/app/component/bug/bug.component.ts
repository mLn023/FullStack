import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Bug } from 'src/app/models/Bug';
import { BugsService } from 'src/app/services/bugs.service';
import { BugDetailComponent } from '../bug-detail/bug-detail.component';

@Component({
  selector: 'app-bug',
  templateUrl: './bug.component.html',
  styleUrls: ['./bug.component.css']
})


export class BugComponent implements AfterViewInit {
  
  public bugs!: Bug[];
  public bugUnit!: Bug;
  displayedColumns: string[] = ['ID', 'name', 'priority', 'status', 'detail'];

  dataSource!: MatTableDataSource<Bug>;
  
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  @ViewChild(MatSort) 
  sort!: MatSort;

  constructor(private bugsServices: BugsService, public dialog: MatDialog) { 
    this.bugsServices.getBugList().subscribe((bugsResponse => {
      this.dataSource = new MatTableDataSource(bugsResponse);
      setTimeout(() => this.dataSource.paginator = this.paginator)
    }))
  }

  deleteBug(id: number): void {
    this.bugsServices.deleteBug(id).subscribe((deleteResponse) => {
      this.bugs = this.bugs.filter(bugs => bugs.id !== id);
    }, (error) => { 
      //TODO
    })
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  openDialog(bug:Bug): void {
    const dialogRef = this.dialog.open(BugDetailComponent, {
      width: '330px',
      height: '400px',
      data: {
                name: bug.name,
                description: bug.description,
                priority: bug.priority,
                status: bug.status,
                date: bug.date,
                developpeur: bug.developpeur
      }
    });
  }
}

