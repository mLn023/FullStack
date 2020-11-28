import { DevelopperServiceService } from './../Services/developper-service.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Developper } from '../Models/Developper';
import { Router } from '@angular/router';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-developper.component.html',
  styleUrls: ['./create-developper.component.css']
})
export class CreateDevelopperComponent implements OnInit {

  createForm!: FormGroup;

  @Output() createEvent = new EventEmitter<Developper>();

  constructor(public formBuilder: FormBuilder,
              private developperService: DevelopperServiceService) { }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      name: '',
      firstname: '',
      function: ''
    });
  }

  onSubmit(developperData: { name: any; firstName: any; function: any; }): void {
    this.createForm.reset();
    const developper: Developper = {
      name: developperData.name,
      firstname: developperData.firstName,
      function: developperData.function
    };
    this.developperService.createDevelopper(developper).subscribe((developperResponse) => {
      this.createEvent.emit(developperResponse);
    });
  }

}