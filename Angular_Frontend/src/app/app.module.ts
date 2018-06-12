import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {AppRoutingModule} from './app-routing.module';
import {HomeComponent} from './home/home.component';
import {RoadsComponent} from './roads/roads.component';
import {FormsModule} from '@angular/forms';
import {RoadService} from './services/road.service';
import {HttpClientModule} from '@angular/common/http';
import {InvoicesComponent} from './invoices/invoices.component';
import {InvoiceService} from './services/invoice.service';
import {PersonService} from './services/person.service';
import {PersonComponent} from './person/person.component';
import {LoginComponent} from './login/login.component';
import {AuthenticationService} from './services/authentication.service';
import {AuthguardService} from './services/authguard.service';


@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    HomeComponent,
    RoadsComponent,
    InvoicesComponent,
    PersonComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule.forRoot()
  ],
  providers: [
    RoadService,
    InvoiceService,
    PersonService,
    AuthenticationService,
    AuthguardService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

