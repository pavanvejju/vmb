import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateUserComponent } from './components/user/create-user/create-user.component';
import { UpdateUserComponent } from './components/user/update-user/update-user.component';
import { UserDetailsComponent } from './components/user/user-details/user-details.component';
import { UserListComponent } from './components/user/user-list/user-list.component';
import { TransactionListComponent } from './components/transaction/transaction-list/transaction-list.component';
import { AddTransactionComponent } from './components/transaction/add-transaction/add-transaction.component';
import { LoginComponent } from './components/login/login.component';
import { PaymentListComponent } from './components/payment/payment-list/payment-list.component';


const routes: Routes = [
  { path : '', component : LoginComponent},
  { path: 'login', component: LoginComponent },
  { path: 'add', component: CreateUserComponent },
  { path: 'update/:id', component: UpdateUserComponent },
  { path: 'details/:id', component: UserDetailsComponent },
  { path: 'userList', component: UserListComponent},
  { path: 'addTransaction', component: AddTransactionComponent},
  { path: 'transactionList', component: TransactionListComponent},
  { path: 'paymentList', component: PaymentListComponent},
  
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
