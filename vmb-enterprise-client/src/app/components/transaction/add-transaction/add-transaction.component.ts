import { Component, OnInit } from '@angular/core';
import { Transaction } from 'src/app/models/transaction';
import { TransactionService } from 'src/app/service/transaction.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.css']
})
export class AddTransactionComponent implements OnInit {

  transaction: Transaction = new Transaction();
  submitted = false;
  constructor(private transactionService: TransactionService,
    private router: Router) { }

    public listItems: Array<{ text: string, value: number }> = [
      { text: "DEBIT", value: 1 },
      { text: "CREDIT", value: 2 }
  ];

  ngOnInit() {
  }

  newUser(): void {
    this.submitted = false;
    this.transaction = new Transaction();
  }

  save() {
    this.transactionService.createTransaction(this.transaction)
      .subscribe(data => console.log(data), error => console.log(error));
    this.transaction = new Transaction();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/transactionList']);
  }
}
