import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from 'src/app/models/payment';
import { PaymentService } from 'src/app/service/payment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-list',
  templateUrl: './payment-list.component.html',
  styleUrls: ['./payment-list.component.css']
})
export class PaymentListComponent implements OnInit {

  paymentList: Observable<Payment[]>;

  constructor(private paymentService: PaymentService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.paymentList = this.paymentService.getPaymentList();
  } 
}
