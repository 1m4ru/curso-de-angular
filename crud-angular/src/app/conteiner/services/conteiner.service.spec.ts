import { TestBed } from '@angular/core/testing';

import { ConteinerService } from './conteiner.service';

describe('ConteinerService', () => {
  let service: ConteinerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConteinerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
