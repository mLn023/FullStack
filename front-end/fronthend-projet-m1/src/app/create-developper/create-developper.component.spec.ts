import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDevelopperComponent } from './create-developper.component';

describe('CreateDevelopperComponent', () => {
  let component: CreateDevelopperComponent;
  let fixture: ComponentFixture<CreateDevelopperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateDevelopperComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateDevelopperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
