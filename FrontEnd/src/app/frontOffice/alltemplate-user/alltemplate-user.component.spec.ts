import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlltemplateUserComponent } from './alltemplate-user.component';

describe('AlltemplateUserComponent', () => {
  let component: AlltemplateUserComponent;
  let fixture: ComponentFixture<AlltemplateUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlltemplateUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlltemplateUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
