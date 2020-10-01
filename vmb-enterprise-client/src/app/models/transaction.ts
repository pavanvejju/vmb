import { User } from './user';
import { Payment } from './payment';

export class Transaction {

    id:number;
	date:string;
	type: string;
	description:string;
	amount:string;
	createdBy:string;
	createdDate:string;
    customer:User;
	payment:Payment;
}
