import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceEqComponent } from './maintenance-eq.component';

describe('MaintenanceEqComponent', () => {
  let component: MaintenanceEqComponent;
  let fixture: ComponentFixture<MaintenanceEqComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaintenanceEqComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MaintenanceEqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
