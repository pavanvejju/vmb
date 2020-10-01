import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateUserComponent } from './components/user/create-user/create-user.component';
import { UserDetailsComponent } from './components/user/user-details/user-details.component';
import { UserListComponent } from './components/user/user-list/user-list.component';
import { UpdateUserComponent } from './components/user/update-user/update-user.component';
import { TransactionListComponent } from './components/transaction/transaction-list/transaction-list.component';
import { AddTransactionComponent } from './components/transaction/add-transaction/add-transaction.component';
import { LoginComponent } from './components/login/login.component';
import { PaymentListComponent } from './components/payment/payment-list/payment-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    UpdateUserComponent,
    UserListComponent,
    UserDetailsComponent,
    TransactionListComponent,
    AddTransactionComponent,
    LoginComponent,
    PaymentListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
