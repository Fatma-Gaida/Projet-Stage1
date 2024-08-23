import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpcomingReservationEComponent } from './upcoming-reservation-e.component';

describe('UpcomingReservationEComponent', () => {
  let component: UpcomingReservationEComponent;
  let fixture: ComponentFixture<UpcomingReservationEComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpcomingReservationEComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpcomingReservationEComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
