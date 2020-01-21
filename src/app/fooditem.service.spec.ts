import { TestBed } from '@angular/core/testing';

import { FooditemService } from './fooditem.service';

describe('FooditemService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FooditemService = TestBed.get(FooditemService);
    expect(service).toBeTruthy();
  });
});
