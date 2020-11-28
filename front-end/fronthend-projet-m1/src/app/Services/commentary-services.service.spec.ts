import { TestBed } from '@angular/core/testing';

import { CommentaryServicesService } from './commentary-services.service';

describe('CommentaryServicesService', () => {
  let service: CommentaryServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommentaryServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
