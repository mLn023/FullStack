import { TestBed } from '@angular/core/testing';

import { BugServicesService } from './bug-services.service';

describe('BugServicesService', () => {
  let service: BugServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BugServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
