import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {HomeComponent} from './home/home.component';
import {RoadsComponent} from './roads/roads.component';
import {InvoicesComponent} from './invoices/invoices.component';
import {PersonComponent} from './person/person.component';
import {LoginComponent} from './login/login.component';
import {AuthguardService} from './services/authguard.service';

const appRoutes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'invoices',
    component: InvoicesComponent,
    canActivate: [AuthguardService]
  },
  {
    path: 'roads',
    component: RoadsComponent,
    canActivate: [AuthguardService]
  },
  {
    path: 'persons/:id',
    component: PersonComponent,
    canActivate: [AuthguardService]
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
