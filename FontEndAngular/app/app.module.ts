import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LogregComponent } from './logreg/logreg.component';
import { RegisterComponent } from './register/register.component';
import { TokenInterceptorInterceptor } from './token-interceptor.interceptor';
import { BadWordFilterPipe } from 'src/assets/bad-word-filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    LogregComponent,
    RegisterComponent,BadWordFilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,HttpClientModule,ReactiveFormsModule,FormsModule

  ],
  providers: [HttpClientModule,{provide:HTTP_INTERCEPTORS,useClass:TokenInterceptorInterceptor,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
