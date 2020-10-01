import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private baseUrl = 'http://localhost:8081/vmb-enterprise/api/v1/payment/';
  constructor(private http: HttpClient) { }

  getPaymentList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
