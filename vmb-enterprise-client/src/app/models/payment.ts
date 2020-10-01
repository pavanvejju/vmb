import { User } from './user';

export class Payment {

    id: number;
    customerName: string;
    startDate: string;
	endDate: string;
	totalCreditAmount: string;
	currentOutstanding: string;
	rateOfInterest: string;
	totalInstallments: number;
	pendingInstallments:number
	createdBy: string;
	createdDate: string;
	modifiedBy: string;
    modifiedDate: string;
    active: boolean;
    customer: User;
}
