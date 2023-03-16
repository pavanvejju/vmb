import { Component, OnInit } from '@angular/core';
import { TransactionService } from 'src/app/service/transaction.service';
import { Router } from '@angular/router';
import { Transaction } from 'src/app/models/transaction';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

 
   transactionList: Observable<Transaction[]>;

  constructor(private transactionService: TransactionService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.transactionList = this.transactionService.getTransactionsList();
  }
}
