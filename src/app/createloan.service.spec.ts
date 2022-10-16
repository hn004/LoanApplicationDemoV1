import { TestBed } from '@angular/core/testing';

import { CreateloanService } from './createloan.service';

describe('CreateloanService', () => {
  let service: CreateloanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateloanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
