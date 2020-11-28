import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DevelopperListComponent } from './developper-list.component';

describe('DevelopperListComponent', () => {
  let component: DevelopperListComponent;
  let fixture: ComponentFixture<DevelopperListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DevelopperListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DevelopperListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
