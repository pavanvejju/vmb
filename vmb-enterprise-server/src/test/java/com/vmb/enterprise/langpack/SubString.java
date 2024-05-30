package com.vmb.enterprise.langpack;

public class SubString {

	
	
	public static void main(String[] args) {
		
		 String str	=	"dlvAddress':{'country':'JP','zipCode':'7100844','addressLineTwo':'Fukui','city':'Kurashiki','addressLineOne':'283-5','state':'','addressLineThree':''},'participantID':null,'requestorId':null,'nameOnCard':'TOMOKO OTSUKA','identityProof':null,'accessCode':null,'bulkShipmentAddressId':0,'cardProgramId':0,'refId':'295255_606db5e40b644e4faa634cd1136c3c97','localeTime':1496188800000,'addressProof':null,'txnAccountDetail':null,'programId':0},'httpStatusMessage':'OK','ResponseBody':{'refId':'295255_606db5e40b644e4faa634cd1136c3c97','localeTime':1496273303609,'errorDetails':[{'errorCode':'0','errorDescription':'Success'}],'usrId':924927,'cardDetail':{'usrId':924927,'nameOnCard':'TOMOKO OTSUKA','proxy':'246654438664474','expiryDate':'X','cardStatus':'READY_TO_ACTIVE','cardType':'PLASTIC','currency':'EUR','cardProgramName':'MyChoiceUK Plastic Card EUR','creationDate':'2017-06-01','txnId':1897640,'deliveryType':'STANDARD_TRACKABLE_DELIVERY','replacedCard':false,'embossedCardholderName':'TOMOKO OTSUKA','pan':'X'},'eligibleForQuestions':false,'userId':924927},";
		 String result = str.substring(str.indexOf("{") + 1, str.indexOf("}"));
		 System.out.println(result); 

	}

}
