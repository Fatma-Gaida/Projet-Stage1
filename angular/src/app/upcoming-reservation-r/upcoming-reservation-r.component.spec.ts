import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpcomingReservationRComponent } from './upcoming-reservation-r.component';

describe('UpcomingReservationRComponent', () => {
  let component: UpcomingReservationRComponent;
  let fixture: ComponentFixture<UpcomingReservationRComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpcomingReservationRComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpcomingReservationRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
