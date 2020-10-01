import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl = 'http://localhost:8081/vmb-enterprise/api/v1/transactions/';

  constructor(private http: HttpClient) { }

  getTransaction(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createTransaction(transaction: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add`, transaction);
  }
  getTransactionsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
