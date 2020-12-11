import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@Angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
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
import { DeveloppeurDetailComponent } from './component/developpeur-detail/developpeur-detail.component';
import { DeveloppeurCreateComponent } from './component/developpeur-create/developpeur-create.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { BugDetailComponent } from './component/bug-detail/bug-detail.component';
import { BugCreateComponent } from './component/bug-create/bug-create.component'


const material =[
  MatTabsModule,
  MatCardModule,
  MatTableModule,
  MatDialogModule,
  MatIconModule,
  MatPaginatorModule,
  MatButtonModule,
  MatSortModule,
  MatFormFieldModule,
  MatSelectModule,
  FormsModule,
  ReactiveFormsModule,
  DragDropModule
];



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DeveloppeurComponent,
    BugComponent,
    DeveloppeurDetailComponent,
    DeveloppeurCreateComponent,
    BugDetailComponent,
    BugCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    material,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
