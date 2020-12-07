import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@Angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginatorModule } from '@angular/material/paginator';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './component/home/home.component';
import { DeveloppeurComponent } from './component/developpeur/developpeur.component';
import { BugComponent } from './component/bug/bug.component';
import { HttpClientModule } from '@angular/common/http';
import { MatSortModule } from '@angular/material/sort';
import { MatButtonModule } from '@angular/material/button';


const material =[
  MatTabsModule,
  MatCardModule,
  MatTableModule,
  MatIconModule,
  MatPaginatorModule,
  MatButtonModule,
  MatSortModule
];



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DeveloppeurComponent,
    BugComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    material,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
